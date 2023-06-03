package com.wht.client.form;

import lombok.Data;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/25 13:37
 */
@Data
public class AddArticleForm {
    String title;
    String image;
    String author;
    String description;
    String content;
}
