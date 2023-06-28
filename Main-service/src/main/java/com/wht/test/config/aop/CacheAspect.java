package com.wht.test.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * redis缓存
 * 注意坑： 使用redisTemplate时，存储的对象需要有无参构造函数
 */
@Component
@Aspect
@Slf4j
public record CacheAspect(RedisTemplate<String, Object> redisTemplate) {

    @Pointcut("@annotation(com.wht.test.config.aop.CacheAnnotation)")
    public void pt() {}

    @Around("pt()")
    public Object async(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuilder redisKeySb = new StringBuilder("AOP").append(":");
        // 类
        String className = joinPoint.getTarget().toString().split("@")[0];
        redisKeySb.append(className).append(":");

        // 方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        redisKeySb.append(methodName);

        //参数
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                redisKeySb.append(":").append(args[i]);
            }
        }

        //从redis中取数据
        Object cache = redisTemplate.opsForValue().get(redisKeySb.toString());

        if (cache != null) {
            return cache;
        }
        //从数据库取数据
        Object result = joinPoint.proceed();
        //加入redis(默认5min缓存)
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        CacheAnnotation cacheAnnotation = method.getAnnotation(CacheAnnotation.class);
        redisTemplate.opsForValue().set(redisKeySb.toString(), result, Long.parseLong(cacheAnnotation.cacheTime()), TimeUnit.SECONDS);
        return result;
    }
}
