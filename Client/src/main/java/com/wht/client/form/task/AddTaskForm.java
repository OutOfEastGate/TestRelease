package com.wht.client.form.task;

import lombok.Data;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 11:05
 */
@Data
public class AddTaskForm {
    /**
     * 任务名称
     */
    String taskName;

    /**
     * 任务
     */
    Task[] task;

    /**
     * 任务到期时间
     */
    String deadline;

    /**
     * 任务到期通知邮箱
     */
    String email;

}

@Data
class Task {

    /**
     * 阶段
     */
    String stage;

    /**
     * 完成度
     */
    Integer completion;
}