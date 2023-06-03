package com.wht.test.config.interceptor.lua;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * description: 将lua脚本的内容加载出来放入到DefaultRedisScript
 *
 * @author wht
 * @createDate 2023/3/13 17:35
 */
@Configuration
public class LuaConfig {

    @Bean("ipLimitLua")
    public DefaultRedisScript<Boolean> ipLimitLua() {
        DefaultRedisScript<Boolean> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/iplimite.lua")));
        defaultRedisScript.setResultType(Boolean.class);
        return defaultRedisScript;
    }
}
