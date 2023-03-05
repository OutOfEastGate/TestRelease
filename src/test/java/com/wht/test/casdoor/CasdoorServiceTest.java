package com.wht.test.casdoor;

import jakarta.annotation.Resource;
import org.casbin.casdoor.entity.CasdoorUser;
import org.casbin.casdoor.service.CasdoorUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 12:40
 */
@SpringBootTest
public class CasdoorServiceTest {
    @Resource
    CasdoorUserService casdoorUserService;

    @Test
    public void testCasdoorUserService() throws IOException {
        for (CasdoorUser user : casdoorUserService.getUsers()) {
            System.out.println(user);
        }
    }
}
