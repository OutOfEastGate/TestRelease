package com.wht.client;

import com.wht.client.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/2/27 20:07
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    String code;

    String msg;

    T data;

    public static Result<?> success() {
        Result result = new Result();
        result.code = "200";
        result.msg = "success";
        return result;
    }

    public static <T> Result<T> success(T o) {
        Result<T> result = new Result();
        result.code = "200";
        result.msg = "success";
        result.data = o;
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.code = "500";
        result.msg = "错误";
        return result;
    }
    public static Result fail(String code, String msg) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static Result fail(ErrorCode error) {
        return fail(error.getCode(), error.getMsg());
    }
}
