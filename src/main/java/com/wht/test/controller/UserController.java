package com.wht.test.controller;

import com.wht.test.client.Result;
import jakarta.annotation.Resource;
import org.casbin.casdoor.service.CasdoorUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getAllUsers")
    public Result getUsers() throws IOException {
        return Result.success(casdoorUserService.getUsers());
    }
}
