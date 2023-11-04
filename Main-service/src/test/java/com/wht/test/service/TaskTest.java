package com.wht.test.service;

import com.wht.client.form.task.AddTaskForm;
import com.wht.test.config.runtime.TaskRuntime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author wanghongtao
 * @data 2023/11/4 22:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {
    @Autowired
    private TaskScheduler taskScheduler;
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Test
    public void scheduleTaskTest() {
        AddTaskForm addTaskForm = new AddTaskForm();
        addTaskForm.setTaskName("test");
        addTaskForm.setEmail("1946066280@qq.com");
        addTaskForm.setDeadline("2023-11-04 22:52:59");
        TaskRuntime taskRuntime = new TaskRuntime();
        taskRuntime.setTaskScheduler(taskScheduler);
        taskRuntime.setJavaMailSender(javaMailSender);

        TaskService taskService = new TaskService();
        taskService.addTask(taskRuntime, addTaskForm);
        System.out.println();
    }

}
