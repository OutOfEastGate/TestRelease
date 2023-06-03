package com.wht.test.controller;

import com.wht.client.Result;
import com.wht.client.exception.CustomException;
import com.wht.client.exception.ErrorCode;
import com.wht.client.util.StorageUtil;
import jakarta.annotation.Resource;
import org.casbin.casdoor.entity.CasdoorUser;
import org.casbin.casdoor.service.CasdoorAuthService;
import org.casbin.casdoor.service.CasdoorUserService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 11:32
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    CasdoorUserService casdoorUserService;
    @Resource
    CasdoorAuthService casdoorAuthService;

    @GetMapping("/getAllUsers")
    public Result<CasdoorUser[]> getUsers() throws IOException {
        return Result.success(casdoorUserService.getUsers());
    }

    @GetMapping("/getUserInfo")
    public Result<CasdoorUser> getUserInfo(@RequestParam String token) {
        CasdoorUser casdoorUser = casdoorAuthService.parseJwtToken(token);
        return Result.success(casdoorUser);
    }

    @GetMapping("/getUserByName")
    public Result<CasdoorUser> getUserByName(String username) {
        CasdoorUser user;
        try {
            user = casdoorUserService.getUser(username);
        } catch (IOException e) {
            throw new CustomException(ErrorCode.USER_NOT_EXISTED);
        }
        return Result.success(user);
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody CasdoorUser casdoorUser) throws IOException {
        if (!StorageUtil.get().equals(casdoorUser.getName())) {
            if (!casdoorUserService.getUser(StorageUtil.get()).isAdmin()) {
                throw new CustomException(ErrorCode.PERMISSION_DENY);
            }
        }
        try {
            casdoorUserService.updateUser(casdoorUser);
        } catch (IOException e) {
            throw new CustomException(ErrorCode.USER_UPDATE_EXCEPTION);
        }
        return Result.success();
    }

    @PostMapping("/deleteUser")
    public Result deleteUser(@RequestBody CasdoorUser casdoorUser) {
        try {
            casdoorUserService.deleteUser(casdoorUser);
        } catch (IOException e) {
            throw new CustomException(ErrorCode.USER_UPDATE_EXCEPTION);
        }
        return Result.success();
    }
}
