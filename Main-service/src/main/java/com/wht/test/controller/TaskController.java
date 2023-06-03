package com.wht.test.controller;

import com.wht.client.Result;
import com.wht.client.form.task.AddTaskForm;
import com.wht.client.form.task.UpdatePolicyForm;
import com.wht.test.service.TaskService;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 10:53
 */
@RequestMapping("/api")
@RestController
public class TaskController {
    private final TaskService taskService;
    private final RedisTemplate<String, Object> redisTemplate;
    private GroovyObject taskScript;

    public TaskController(TaskService taskService, GroovyObject taskScript, RedisTemplate<String, Object> redisTemplate) {
        this.taskService = taskService;
        this.taskScript = taskScript;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/addTask")
    public Result addTask(@RequestBody AddTaskForm addTaskForm) {
        taskService.addTask(addTaskForm);
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
        return Result.success(taskScript.invokeMethod("hello",null));
    }

    @GetMapping("/getScript")
    public Result<Object> getScript() {
        return Result.success(redisTemplate.opsForValue().get("script"));
    }
}
