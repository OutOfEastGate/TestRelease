package com.wht.test.config.interceptor;

import com.wht.test.client.exception.CustomException;
import com.wht.test.client.exception.ErrorCode;
import com.wht.test.client.properties.PermissionConfig;
import com.wht.test.client.util.StorageUtil;
import com.wht.test.config.interceptor.check.IpLimitCheck;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.casbin.casdoor.entity.CasdoorUser;
import org.casbin.casdoor.service.CasdoorAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 16:15
 */
@Slf4j
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    PermissionConfig permissionConfig;
    @Resource
    IpLimitCheck ipLimitCheck;
    @Resource
    private CasdoorAuthService casdoorAuthService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //跨域
        setCorsConfig(response);
        //ip限流
        ipLimitCheck.ipLimitCheck(request);
        String requestURI = request.getRequestURI();
        String token = request.getHeader("Authorization");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if (!requestURI.startsWith("/api")) {
            return true;
        }
        if (permissionConfig.getPathNoNeedToken().contains(requestURI)) {
            return true;
        }
        //执行检验token流程
        CasdoorUser casdoorUser = null;
        try {
            casdoorUser = casdoorAuthService.parseJwtToken(token);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new CustomException(ErrorCode.USER_LOGIN_ERROR);
        }
        StorageUtil.set(casdoorUser.getName());
        log.info("验证token"+casdoorUser.getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //移除threadLocal
        StorageUtil.remove();
        log.info("移除threadLocal");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    private void setCorsConfig(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
    }
}
