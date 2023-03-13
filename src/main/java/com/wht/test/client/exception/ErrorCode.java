package com.wht.test.client.exception;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 16:40
 */
public enum ErrorCode {
    USER_LOGIN_ERROR("401", "未登录"),
    IP_LIMIT("403","访问频繁");


    private final String code;
    private final String msg;
    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
