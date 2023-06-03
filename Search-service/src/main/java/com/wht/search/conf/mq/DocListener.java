package com.wht.search.conf.mq;

import com.wht.client.constants.MQConstants;
import com.wht.search.repository.EsRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/2 16:56
 */
@Component
public class DocListener {
    @Autowired
    EsRepository esRepository;

    @RabbitListener(queues = MQConstants.DOC_INSERT_QUEUE)
    public void listenDocInsertOrUpdate(String id) {
        esRepository.addOrUpdateArticle(id);
    }

    @RabbitListener(queues = MQConstants.DOC_DELETE_QUEUE)
    public void listenDocDelete(String id) {
       esRepository.deleteArticle(id);
    }

    @RabbitListener(queues = MQConstants.DOC_UPDATE_QUEUE)
    public void listenDocUpdate(String id) {
        esRepository.addOrUpdateArticle(id);
    }
}
