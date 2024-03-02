package com.wht.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wht.client.Result;
import com.wht.client.form.task.AddTaskForm;
import com.wht.client.form.task.UpdatePolicyForm;
import com.wht.test.config.runtime.JacksonUtils;
import com.wht.test.config.runtime.TaskRuntime;
import com.wht.test.service.TaskService;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 10:53
 */
@Slf4j
@RequestMapping("/api")
@RestController
public class TaskController {
    private final TaskService taskService;
    private final RedisTemplate<String, Object> redisTemplate;
    private GroovyObject taskScript;

    private JavaMailSenderImpl javaMailSender;

    private TaskScheduler taskScheduler;

    public TaskController(TaskService taskService, GroovyObject taskScript, RedisTemplate<String, Object> redisTemplate,
                          JavaMailSenderImpl javaMailSender,
                          TaskScheduler taskScheduler) {
        this.taskService = taskService;
        this.taskScript = taskScript;
        this.redisTemplate = redisTemplate;
        this.javaMailSender = javaMailSender;
        this.taskScheduler = taskScheduler;
    }

    @PostMapping("/addTask")
    public Result addTask(@RequestBody AddTaskForm addTaskForm) {
        TaskRuntime taskRuntime = new TaskRuntime();
        taskRuntime.setJavaMailSender(javaMailSender);
        taskRuntime.setTaskScheduler(taskScheduler);
        taskService.addTask(taskRuntime, addTaskForm);
        return Result.success();
    }

    @GetMapping("/getTaskPolicy")
    public Result<Object> getTaskPolicy() {
        return Result.success(taskScript.invokeMethod("hello",null));
    }

    @PostMapping("/updatePolicy")
    public Result updatePolicy(@RequestBody UpdatePolicyForm updatePolicyForm) {
        if(!redisTemplate.opsForValue().get("script").equals(updatePolicyForm.getScript())){
            GroovyClassLoader classLoader = new GroovyClassLoader();
            try {
                Class<?> groovyClass = classLoader.parseClass(updatePolicyForm.getScript());
                this.taskScript = (GroovyObject) groovyClass.getDeclaredConstructor().newInstance();
                redisTemplate.opsForValue().set("script", updatePolicyForm.getScript());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        log.info("execute script start, {}", updatePolicyForm.getScript());
        Object result = taskScript.invokeMethod("fn", null);
        String json = JacksonUtils.toJson(result);
        log.info("execute script end,res: {}", json);
        return Result.success(json);
    }

    @GetMapping("/getScript")
    public Result<Object> getScript() {
        return Result.success(redisTemplate.opsForValue().get("script"));
    }
}
