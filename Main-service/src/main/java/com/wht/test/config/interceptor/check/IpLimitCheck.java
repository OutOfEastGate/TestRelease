package com.wht.test.config.interceptor.check;

import com.wht.client.exception.CustomException;
import com.wht.client.exception.ErrorCode;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.assertj.core.util.Lists;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/13 17:57
 */
@Component
public class IpLimitCheck {
    @Resource(name = "ipLimitLua")
    DefaultRedisScript<Boolean> ipLimitLua;
    @Resource
    RedisTemplate<String,String> redisTemplate;

    public Boolean ipLimitCheck(HttpServletRequest request) {
        String remoteIp = request.getRemoteHost();
        if ("0:0:0:0:0:0:0:1".equals(remoteIp)) remoteIp = "127.0.0.1";
        //ip限流，100秒200次
        Boolean isAllowed = redisTemplate.execute(ipLimitLua, Lists.newArrayList(remoteIp), 5, 100);
        if (Boolean.FALSE.equals(isAllowed)) {
            throw new CustomException(ErrorCode.IP_LIMIT);
        }
        return true;
    }
}
