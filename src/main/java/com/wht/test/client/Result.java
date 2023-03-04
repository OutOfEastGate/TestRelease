package com.wht.test.client;

import lombok.Data;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/2/27 20:07
 */
@Data
public class Result {
    String code;

    String msg;

    Object data;

    public static Result success() {
        Result result = new Result();
        result.code = "200";
        result.msg = "success";
        return result;
    }

    public static Result success(Object o) {
        Result result = new Result();
        result.code = "200";
        result.msg = "success";
        result.data = o;
        return result;
    }

    public static Result fail(String code, String msg) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }
}
