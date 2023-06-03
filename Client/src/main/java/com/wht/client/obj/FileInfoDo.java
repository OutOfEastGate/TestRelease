package com.wht.client.obj;

import cn.hutool.core.lang.Dict;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/27 17:01
 */
@Data
@Document("fileInfo")
public class FileInfoDo {
    @Id
    private String id;
    private String url;
    private Long size;
    private String filename;
    private String originalFilename;
    private String basePath;
    private String path;
    private String ext;
    private String contentType;
    private String platform;
    private String objectId;
    private String objectType;
    private Dict attr;
    private String createTime;
}
