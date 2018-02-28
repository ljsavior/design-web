package com.eternal.design.web.controller;

import com.eternal.design.chat.Message;
import com.eternal.design.chat.SocketSessionRegistry;
import com.eternal.design.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class ChatController {
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private SocketSessionRegistry socketSessionRegistry;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @RequestMapping("/chat.html")
    public String list(String from, String to, Model model) {
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        return "chat/chat";
    }


    @MessageMapping("/chat/msg")
    public void onMsg(Message message) throws Exception {
        String sessionId = socketSessionRegistry.getSessionId(message.getTo());

        if(sessionId != null) {
            template.convertAndSendToUser(sessionId, "/topic/chat", message, createHeaders(sessionId));
        } else {
            redisTemplate.opsForList().rightPush(Constants.WEB_CHAT_USER_MSG_QUEUE_OFFLINE_PREFIX +message.getTo(), message.toString());
        }

    }

    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }

}
