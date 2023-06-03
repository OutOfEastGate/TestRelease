package com.wht.test.config.mail;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Data
@Component
@ConfigurationProperties(prefix = "spring.mail")
public class MailProperties {
    String host;
    String port;
    String username;
    String password;
    String defaultEncoding;
    Properties properties;
}