package com.wht.client.obj;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "website")
@Data
public class WebsiteDo {
    @Id
    String id;

    String name;

    String link;

    String desc;

    /**
     * 爬虫抓取
     */
    String icon;

    /**
     * 爬虫抓取
     */
    String title;
}
