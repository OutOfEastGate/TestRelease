package com.wht.test.controller;

import com.wht.test.client.Result;
import com.wht.test.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/2/27 20:06
 */
@RestController
public class TestController {
    @Autowired
    TimeService timeService;

    @GetMapping("/hello")
    public Result test() {
        return timeService.test();
    }
}
