package com.wht.test.config.exception;

import com.wht.client.Result;
import com.wht.client.exception.CustomException;
import com.wht.client.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/3/3 16:43
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerConfig {
    @ExceptionHandler(CustomException.class)
    public Result handCustomException(CustomException e) {
        log.error(e.getMsg());
        return Result.fail(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public Result defaultHandler(Exception e) {
        e.printStackTrace();
        return Result.fail(ErrorCode.ERROR);
    }
}
