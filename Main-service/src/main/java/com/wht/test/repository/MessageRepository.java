package com.wht.test.repository;

import com.wht.client.obj.MessageDo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/26 19:43
 */
public interface MessageRepository extends MongoRepository<MessageDo,String> {
}
