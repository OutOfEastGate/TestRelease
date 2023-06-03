package com.wht.client.dto;

import lombok.Data;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/25 19:10
 */
@Data
public class AllArticlesDto {
    String id;
    String title;
    String author;
    String authorAvatar;
    String image;
    String description;
}
