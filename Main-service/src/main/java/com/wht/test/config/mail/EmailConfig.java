package com.wht.test.config.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
    final private MailProperties mailProperties;

    public EmailConfig(MailProperties mailProperties) {
        this.mailProperties = mailProperties;
    }

    @Bean
    JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailProperties.getHost());
        javaMailSender.setUsername(mailProperties.getUsername());
        javaMailSender.setPassword(mailProperties.getPassword());
        javaMailSender.setDefaultEncoding(mailProperties.getDefaultEncoding());
        javaMailSender.setJavaMailProperties(mailProperties.getProperties());
        return javaMailSender;
    }
}