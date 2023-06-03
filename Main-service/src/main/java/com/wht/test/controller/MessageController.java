package com.wht.test.controller;

import com.wht.client.Result;
import com.wht.client.form.message.AddMailMessageForm;
import com.wht.client.form.message.AddMessageForm;
import com.wht.client.obj.MessageDo;
import com.wht.test.config.sse.SseUtf8;
import com.wht.test.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * <p>
 *     消息推送，邮件推送
 * </p>
 *
 * @author wht
 * @createDate 2023/4/26 19:41
 */
@Slf4j
@RequestMapping("/api")
@RestController
public class MessageController {
    private static final Map<String, SseUtf8> sseEmitterMap = new ConcurrentHashMap<>();
    private final AtomicInteger count = new AtomicInteger();

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/getAllMessages")
    public Result<List<MessageDo>> getAllMessages() {
        return Result.success(messageService.getAllMessages());
    }

    @PostMapping("/addMessage")
    public Result addMessage(@RequestBody AddMessageForm addMessageForm) {
        messageService.addMessage(addMessageForm);
        return Result.success();
    }

    @PostMapping("/addMailMessage")
    public Result addMailMessage(@RequestBody AddMailMessageForm addMailMessageForm) {
        messageService.addMailMessage(addMailMessageForm);
        return Result.success();
    }

    @GetMapping(value = "/sse/get",  produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter sseGet(String userId) {
        try {
            // 设置超时时间，0表示不过期。默认30秒
            SseUtf8 sseEmitter = new SseUtf8(0L);
            // 注册回调
            sseEmitter.onCompletion(completionCallBack(userId));
            sseEmitter.onError(errorCallBack(userId));
            sseEmitter.onTimeout(timeoutCallBack(userId));
            sseEmitterMap.put(userId, sseEmitter);
            count.getAndIncrement();
            sseSend("用户: " + userId + "已上线");
            return sseEmitter;
        } catch (Exception e) {
            count.getAndDecrement();
            log.error(e.getMessage());
        }
        return null;
    }

    private Runnable timeoutCallBack(String userId) {
        return ()->{
            count.getAndDecrement();
            sseEmitterMap.remove(userId);
            log.error(userId + "连接超时");
        };
    }

    private Consumer<Throwable> errorCallBack(String userId) {
        return throwable -> log.error(userId + "注册失败");
    }

    private Runnable completionCallBack(String userId) {
        return () -> {
            count.getAndDecrement();
            sseEmitterMap.remove(userId);
            log.info(userId + "下线啦");
        };
    }

    @PostMapping("/sse/send")
    public Result sseSend(String message) {
        for (Map.Entry<String, SseUtf8> next : sseEmitterMap.entrySet()) {
            try {
                next.getValue().send(message, MediaType.APPLICATION_JSON);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Result.success();
    }

    @GetMapping("/getOnlineUserNum")
    public Result<Integer> getOnlineUserNum() {
        return Result.success(sseEmitterMap.size());
    }
}
