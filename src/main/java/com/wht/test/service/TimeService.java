package com.wht.test.service;

import com.wht.test.client.Restlut;
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
    public Restlut test() {
        Restlut restlut = new Restlut();
        restlut.setCode("200");
        restlut.setMsg("success");
        restlut.setData(new Date());
        return restlut;
    }
}
