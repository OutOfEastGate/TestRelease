package com.wht.client.constants;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/14 17:42
 */
public class MQConstants {
    /**
     * 交换机
     */
    public final static String DOC_EXCHANGE = "article.topic";

    /**
     * 队列
     */
    public final static String DOC_INSERT_QUEUE = "article.insert.queue";

    public final static String DOC_DELETE_QUEUE = "article.delete.queue";

    public final static String DOC_UPDATE_QUEUE = "article.update.queue";

    /**
     * RoutingKey
     */
    public final static String DOC_INSERT_KEY = "article.insert";

    public final static String DOC_DELETE_KEY = "article.delete";

    public final static String DOC_UPDATE_KEY = "article.update";
}
