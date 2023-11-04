package com.wht.test.config.runtime;

import lombok.Data;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.TaskScheduler;

/**
 * @author wanghongtao
 * @data 2023/11/4 22:12
 */
@Data
public class TaskRuntime {
    private JavaMailSender javaMailSender;
    private TaskScheduler taskScheduler;
}
