package com.wht.test.controller;

import com.wht.client.Result;
import jakarta.annotation.Resource;
import org.casbin.casdoor.service.CasdoorResourceService;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/19 21:41
 */
public class ResourceController {
    @Resource
    CasdoorResourceService casdoorResourceService;

    public Result upload() {
//        casdoorResourceService.uploadResource();
        return Result.success();
    }
}
