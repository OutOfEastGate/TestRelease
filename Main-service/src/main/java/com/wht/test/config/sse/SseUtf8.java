package com.wht.test.config.sse;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.nio.charset.StandardCharsets;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/28 16:50
 */
public class SseUtf8 extends SseEmitter {
    public SseUtf8(Long timeout) {
        super(timeout);
    }

    @Override
    protected void extendResponse(@NotNull ServerHttpResponse outputMessage) {
        super.extendResponse(outputMessage);
        outputMessage.getHeaders().setContentType(new MediaType(MediaType.TEXT_EVENT_STREAM, StandardCharsets.UTF_8));
    }
}
