package com.wht.client.form.message;

import lombok.Data;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/11 22:59
 */
@Data
public class AddMailMessageForm {
    String title;
    String text;
    String targetMail;
}
