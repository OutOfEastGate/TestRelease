package com.wht.test;

import com.wht.test.service.TimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/2/27 20:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TimeServiceTest {
    @Autowired
    TimeService timeService;

    @Test
    public void testGetTime() {
        timeService.test();
    }
}
