package com.wht.test.controller;

import com.wht.client.Result;
import com.wht.client.dto.LoginResultDto;
import com.wht.client.exception.CustomException;
import com.wht.client.exception.ErrorCode;
import com.wht.client.form.UserLoginForm;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.val;
import org.casbin.casdoor.entity.CasdoorUser;
import org.casbin.casdoor.exception.CasdoorAuthException;
import org.casbin.casdoor.service.CasdoorAuthService;
import org.casbin.casdoor.service.CasdoorUserService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 12:58
 */
@AllArgsConstructor
@Controller
public class AccountController {

    private final CasdoorAuthService casdoorAuthService;

    private final CasdoorUserService casdoorUserService;

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 获取casdoor登录地址
     * @param origin 前端endpoint
     * @return 登录url
     */
    @ResponseBody
    @RequestMapping("/api/getLoginUrl")
    public Result<String> casdoorLogin(String origin) {
        String signinUrl;
        if (origin.startsWith("http")) {
            signinUrl = casdoorAuthService.getSigninUrl(origin+"/callback");
        }else {
            signinUrl = casdoorAuthService.getSigninUrl("http://"+origin+"/callback");
        }
        return Result.success(signinUrl);
    }

    /**
     * 登录
     * @param userLoginForm 账号密码
     * @return 登录是否成功
     */
    @ResponseBody
    @RequestMapping("/api/login")
    public Result login(@RequestBody UserLoginForm userLoginForm,  HttpSession httpSession) {
        try {
            CasdoorUser user = casdoorUserService.getUser(userLoginForm.getUsername());
            String password = user.getPassword();
            if (password.equals(userLoginForm.getPassword())) {
                return Result.success();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.fail();
    }

    /**
     * 处理casdoor回调
     * @param code 状态码
     * @param state 范围
     * @param httpSession session
     * @return token与用户信息
     */
    @ResponseBody
    @RequestMapping("/api/callback")
    public Result<LoginResultDto> casdoorCallBack(String code, String state, HttpSession httpSession) {
        String token = "";
        CasdoorUser user = null;
        try {
            token = casdoorAuthService.getOAuthToken(code, state);
            user = casdoorAuthService.parseJwtToken(token);
        } catch (CasdoorAuthException e) {
            throw new CustomException(ErrorCode.USER_LOGIN_ERROR);
        }
        httpSession.setAttribute("casdoorUser", user);
        LoginResultDto loginResultDto = new LoginResultDto();
        loginResultDto.setCasdoorUser(user);
        loginResultDto.setToken(token);
        return Result.success(loginResultDto);
    }

    @ResponseBody
    @RequestMapping("/api/visitor")
    public Result<LoginResultDto> visitorLogin() {
        String visitorToken = stringRedisTemplate.opsForValue().get("VISITOR_TOKEN");
        CasdoorUser user = casdoorAuthService.parseJwtToken(visitorToken);
        LoginResultDto loginResultDto = new LoginResultDto(visitorToken, user);
        return Result.success(loginResultDto);
    }
}
