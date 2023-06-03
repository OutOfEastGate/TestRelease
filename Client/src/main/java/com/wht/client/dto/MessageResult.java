package com.wht.client.dto;

import lombok.Data;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/20 20:15
 */
@Data
public class MessageResult {
    Boolean isSystem;
    String message;
    String fromName;
    String toName;
}
