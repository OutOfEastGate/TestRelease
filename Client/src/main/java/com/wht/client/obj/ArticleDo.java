package com.wht.client.obj;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/25 13:33
 */
@Data
@Document(collection = "article")
public class ArticleDo {
    @Id
    private String id;
    private String title;
    private String author;
    private String image;
    private String description;
    private String content;
}
