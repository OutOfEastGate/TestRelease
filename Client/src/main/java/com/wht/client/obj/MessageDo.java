package com.wht.client.obj;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/26 19:43
 */
@Data
@Document(collection = "message")
public class MessageDo {
    @Id
    String id;
    String username;
    String message;
    String createTime;
    List<MessageDo> childMessages;
}
