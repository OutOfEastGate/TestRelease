package com.wht.test.controller;

import com.wht.client.Result;
import com.wht.client.dto.PageResult;
import com.wht.client.form.PageForm;
import com.wht.client.obj.IpDo;
import com.wht.test.service.IpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 20:52
 */
@RequestMapping("/api")
@RestController
public class IpController {
    private final IpService ipService;

    public IpController(IpService ipService) {
        this.ipService = ipService;
    }

    @GetMapping("/getAllIp")
    public Result<PageResult<List<IpDo>>> getAllIp(PageForm pageForm) {
        return Result.success(ipService.getAllIp(pageForm));
    }
}
