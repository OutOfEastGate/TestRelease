package com.wht.search.conf.mq;

import com.wht.client.constants.MQConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: 创建交换机与队列并绑定
 *
 * @author wht
 * @createDate 2023/4/14 17:46
 */
@Configuration
public class MQConfig {

    /**
     * 交换机
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(MQConstants.DOC_EXCHANGE,true,true);
    }

    /**
     * 插入队列
     * @return
     */
    @Bean
    public Queue insertQueue() {
        return new Queue(MQConstants.DOC_INSERT_QUEUE,true);
    }

    /**
     * 删除队列
     * @return
     */
    @Bean
    public Queue deleteQueue() {
        return new Queue(MQConstants.DOC_DELETE_QUEUE,true);
    }

    /**
     * 更新队列
     */
    @Bean
    public Queue updatetQueue() {
        return new Queue(MQConstants.DOC_UPDATE_QUEUE,true);
    }

    /**
     * 绑定队列与交换机
     * @return
     */
    @Bean
    public Binding insertQueueBinding() {
        return BindingBuilder.bind(insertQueue()).to(topicExchange()).with(MQConstants.DOC_INSERT_KEY);
    }

    @Bean
    public Binding deleteQueueBinding() {
        return BindingBuilder.bind(deleteQueue()).to(topicExchange()).with(MQConstants.DOC_DELETE_KEY);
    }

    @Bean
    public Binding updateQueueBinding() {
        return BindingBuilder.bind(deleteQueue()).to(topicExchange()).with(MQConstants.DOC_UPDATE_KEY);
    }
}
