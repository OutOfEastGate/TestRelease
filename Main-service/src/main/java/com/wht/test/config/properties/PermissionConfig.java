package com.wht.test.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 16:23
 */
@Component
@ConfigurationProperties(prefix = "permission")
@Data
public class PermissionConfig {
    List<String> pathNoNeedToken;
    List<String> pathForAdmin;
}
