package com.wht.test.controller;

import com.wht.test.client.Result;
import com.wht.test.client.dto.LoginResultDto;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.casbin.casdoor.entity.CasdoorUser;
import org.casbin.casdoor.exception.CasdoorAuthException;
import org.casbin.casdoor.service.CasdoorAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 12:58
 */
@Controller
public class AccountController {
    @Resource
    private CasdoorAuthService casdoorAuthService;

    @RequestMapping("/login")
    public String login() {
        return "redirect:" + casdoorAuthService.getSigninUrl("http://localhost:3001/callback");
    }

    @ResponseBody
    @RequestMapping("/callback")
    public Object casdoorCallBack(String code, String state, HttpSession httpSession) {
        String token = "";
        CasdoorUser user = null;
        try {
            token = casdoorAuthService.getOAuthToken(code, state);
            user = casdoorAuthService.parseJwtToken(token);
        } catch (CasdoorAuthException e) {
            e.printStackTrace();
        }
        httpSession.setAttribute("casdoorUser", user);
        LoginResultDto loginResultDto = new LoginResultDto();
        loginResultDto.setCasdoorUser(user);
        loginResultDto.setToken(token);
        return Result.success(loginResultDto);
    }
}
