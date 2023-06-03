package com.wht.client.obj;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 20:14
 */
@Data
@Document(collection = "ip")
public class IpDo {
    String id;
    /**
     * ip
     */
    String IP;

    String country;

    String city;

    String timezone;

    /**
     * 访问次数
     */
    Long times;

    /**
     * 最近访问日期
     */
    String date;
}
