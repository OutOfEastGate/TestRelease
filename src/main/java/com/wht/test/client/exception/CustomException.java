package com.wht.test.client.exception;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 16:36
 */
public class CustomException extends RuntimeException{
    String code;

    String msg;

    public CustomException(String msg) {
        this.msg = msg;
    }
    public CustomException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CustomException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
