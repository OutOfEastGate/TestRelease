package com.wht.client.obj;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * description: 文件分类
 *
 * @author wht
 * @createDate 2023/5/10 21:20
 */
@Data
@Document("fileType")
public class FileTypeDo {
    @Id
    String id;

    String image;

    String title;

    String description;
}
