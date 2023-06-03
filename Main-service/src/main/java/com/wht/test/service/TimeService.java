package com.wht.test.service;

import com.wht.client.Result;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/2/27 20:34
 */
@Service
public class TimeService {
    public Result test() {
        return Result.success(new Date());
    }
}
