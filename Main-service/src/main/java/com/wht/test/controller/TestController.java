package com.wht.test.controller;

import com.wht.client.Result;
import com.wht.client.dto.SystemInfoDto;
import com.wht.test.service.SystemService;
import com.wht.test.service.TimeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * description:
 *
 * @author wht
 * @createDate 2023/2/27 20:06
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class TestController {

    private final TimeService timeService;

    private final SystemService systemService;

    @GetMapping("/hello")
    public Result test() {
        return timeService.test();
    }

    @GetMapping("/systemInfo")
    public Result<SystemInfoDto> systemInfo() {
        return Result.success(systemService.getSystemInfo());
    }
}
