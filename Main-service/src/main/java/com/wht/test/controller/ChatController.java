package com.wht.test.controller;

import com.alibaba.fastjson.JSON;
import com.wht.client.dto.MessageResult;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/20 20:24
 */
@Slf4j
@ServerEndpoint("/api/chat/{username}")
@Component
public class ChatController {

    private static AtomicInteger onlineCount = new AtomicInteger(0);

    private static Map<String,ChatController> webSocketSet = new ConcurrentHashMap<>();

    private static List<String> onlineUsers = new ArrayList<>();

    private Session session;

    private String username = "";

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        webSocketSet.put(username,this);
        onlineCount.addAndGet(1);
        this.username = username;
        this.session = session;
        onlineUsers.add(username);
        //通知每一个人
        webSocketSet.forEach((userid,obj)-> sendMessage(obj,onlineUsers.toArray(new String[]{})));
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        MessageResult result = JSON.parseObject(message, MessageResult.class);
        if (result.getIsSystem()) {
            //向每个人都发一遍
            webSocketSet.forEach((userid,obj)->{
                sendMessage(obj,message);
            });
        } else {
            sendMessage(webSocketSet.get(result.getToName()),message);
        }
    }

    @OnClose
    public void onClose(Session session) {
        webSocketSet.remove(this.username);
        onlineCount.decrementAndGet();
        onlineUsers.remove(this.username);
        //通知每一个人
        webSocketSet.forEach((userid,obj)-> sendMessage(obj,onlineUsers.toArray(new String[]{})));
    }

    public void sendMessage(ChatController controller,String message) {
        try {
            controller.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(ChatController controller,String[] users) {
        try {
            controller.session.getBasicRemote().sendText(JSON.toJSONString(users));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
