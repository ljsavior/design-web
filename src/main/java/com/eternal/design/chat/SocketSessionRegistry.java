package com.eternal.design.chat;

import com.eternal.design.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by eternal on 2018/2/27.
 */
@Component
public class SocketSessionRegistry {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SimpMessagingTemplate template;

    private Executor exec = Executors.newCachedThreadPool();

    public String getSessionId(String user) {
        return (String)redisTemplate.opsForHash().get(Constants.WEB_CHAT_USER_SESSION_HASH_KEY, user);
    }

    public String getUser(String sessionId) {
        return (String)redisTemplate.opsForHash().get(Constants.WEB_CHAT_SESSION_USER_HASH_KEY, sessionId);
    }

    public void registerSessionId(String user, String sessionId) {
        Assert.notNull(user, "User name must not be null");
        Assert.notNull(sessionId, "SessionId must not be null");

        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(Constants.WEB_CHAT_USER_SESSION_HASH_KEY, user, sessionId);
        hashOperations.put(Constants.WEB_CHAT_SESSION_USER_HASH_KEY, sessionId, user);

        System.out.println("register: " + user + "-" + sessionId);

        exec.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
            ListOperations<String, Object> listOperations = redisTemplate.opsForList();

            String key = Constants.WEB_CHAT_USER_MSG_QUEUE_OFFLINE_PREFIX + user;
            Long size;
            while((size = listOperations.size(key)) != null && size > 0) {
                Message msg = Message.fromJSONString((String)redisTemplate.opsForList().leftPop(key));
                template.convertAndSendToUser(sessionId, "/topic/chat", msg, createHeaders(sessionId));
            }
        });
    }

    public void unregisterSessionId(String sessionId) {
        Assert.notNull(sessionId, "SessionId must not be null");

        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        String user = (String)hashOperations.get(Constants.WEB_CHAT_SESSION_USER_HASH_KEY, sessionId);
        if(user != null) {
            hashOperations.delete(Constants.WEB_CHAT_SESSION_USER_HASH_KEY, sessionId);
            hashOperations.delete(Constants.WEB_CHAT_USER_SESSION_HASH_KEY, user);
        }

        System.out.println("unregister: " + user + "-" + sessionId);
    }

    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }

}
