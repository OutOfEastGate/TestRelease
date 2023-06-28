package com.wht.test.config.interceptor;

import com.wht.client.exception.CustomException;
import com.wht.client.exception.ErrorCode;
import com.wht.client.util.StorageUtil;
import com.wht.test.config.interceptor.check.IpLimitCheck;
import com.wht.test.config.properties.PermissionConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.casbin.casdoor.entity.CasdoorUser;
import org.casbin.casdoor.service.CasdoorAuthService;
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
    private final PermissionConfig permissionConfig;

    private final IpLimitCheck ipLimitCheck;

    private final CasdoorAuthService casdoorAuthService;

    public LoginInterceptor(PermissionConfig permissionConfig, CasdoorAuthService casdoorAuthService, IpLimitCheck ipLimitCheck) {
        this.permissionConfig = permissionConfig;
        this.ipLimitCheck = ipLimitCheck;
        this.casdoorAuthService = casdoorAuthService;
    }

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
        CasdoorUser casdoorUser;
        try {
            casdoorUser = casdoorAuthService.parseJwtToken(token);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new CustomException(ErrorCode.USER_LOGIN_ERROR);
        }
        if (permissionConfig.getPathForAdmin().contains(requestURI) && !casdoorUser.isAdmin()) {
            throw new CustomException(ErrorCode.PERMISSION_DENY);
        }
        StorageUtil.set(casdoorUser.getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //移除threadLocal
        StorageUtil.remove();
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    private void setCorsConfig(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
    }
}
