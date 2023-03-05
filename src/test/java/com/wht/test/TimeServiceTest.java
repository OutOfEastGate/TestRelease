package com.wht.test;

import com.wht.test.service.TimeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
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
@Slf4j
public class TimeServiceTest {
    @Autowired
    TimeService timeService;

    @Test
    public void testGetTime() {
        log.info(timeService.test().toString());
    }
}
