package com.wht.test.config.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 10:55
 */
@Configuration
@EnableAsync
public class TaskExecutorConfig {

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5); // 核心线程数
        scheduler.setThreadNamePrefix("MyScheduler-"); // 线程名称前缀
        scheduler.setRemoveOnCancelPolicy(true); // 取消任务时从队列中移除
        scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy()); // 拒绝策略
        scheduler.setWaitForTasksToCompleteOnShutdown(true); // 关闭时等待所有任务完成
        scheduler.setAwaitTerminationSeconds(60); // 关闭时等待的最大秒数
        return scheduler;
    }
}
