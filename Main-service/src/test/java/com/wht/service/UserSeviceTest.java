package com.wht.service;

import org.casbin.casdoor.entity.CasdoorUser;
import org.casbin.casdoor.service.CasdoorAuthService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/31 22:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSeviceTest {
    @Autowired
    CasdoorAuthService authService;

    /**
     * 登录测试
     */
    @Test
    public void testLogin() {
        CasdoorUser user = authService.parseJwtToken("token");
        Assert.assertNotNull(user);
    }
}
