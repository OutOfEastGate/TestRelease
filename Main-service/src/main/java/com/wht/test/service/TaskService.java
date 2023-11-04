package com.wht.test.service;

import com.wht.client.exception.CustomException;
import com.wht.client.exception.ErrorCode;
import com.wht.client.form.task.AddTaskForm;
import com.wht.test.config.runtime.TaskRuntime;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 11:03
 */
@Slf4j
@Service
public class TaskService {


    public void addTask(TaskRuntime taskRuntime, AddTaskForm addTaskForm) {
        String deadlineString = addTaskForm.getDeadline();
        String pattern = "yyyy-MM-dd HH:mm:ss";

        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date deadline;
        try {
            deadline = formatter.parse(deadlineString);
        } catch (ParseException e) {
            throw new CustomException(ErrorCode.TIME_EXISTED);
        }
        Date now = new Date();
        if (deadline.before(now)) {
            throw new CustomException(ErrorCode.TIME_EXISTED);
        }
        JavaMailSender javaMailSender = taskRuntime.getJavaMailSender();
        taskRuntime.getTaskScheduler().schedule(() -> {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper;
            try {
                helper = new MimeMessageHelper(mimeMessage, true);
                //标题
                helper.setSubject(addTaskForm.getTaskName());
                //内容(html)
                String text = "<p>您的任务: " + addTaskForm.getTaskName() + "将于" + addTaskForm.getDeadline() + "到期" +
                        "，请尽快处理</p>";
                helper.setText(text, true);
                //接受者
                helper.setTo(addTaskForm.getEmail());
                helper.setFrom("1946066280@qq.com");
                javaMailSender.send(mimeMessage);
                log.error("邮件发送成功");
            } catch (Exception e) {
                log.error("邮件发送失败");
                e.printStackTrace();
                throw new CustomException(ErrorCode.MAIL_ERROR);
            }
        }, deadline.toInstant());
    }
}
