package com.wht.test.config.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scripting.support.ResourceScriptSource;

import java.io.IOException;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/28 22:08
 */
@AllArgsConstructor
@Configuration
public class GroovyConf {
    private final RedisTemplate<String, Object> redisTemplate;

    @Bean(name = "taskScript")
    public GroovyObject getGroovyShell() {
        try {
            GroovyClassLoader classLoader = new GroovyClassLoader();
            Class<?> groovyClass = classLoader.parseClass((String) redisTemplate.opsForValue().get("script"));
            return  (GroovyObject) groovyClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
