package com.wht.test.casdoor;

import jakarta.annotation.Resource;
import org.casbin.casdoor.entity.CasdoorUser;
import org.casbin.casdoor.service.CasdoorUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 12:40
 */
@SpringBootTest
@RunWith(SpringRunner.class)
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
