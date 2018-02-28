package com.eternal.design.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Component
public class STOMPConnectEventListener implements ApplicationListener<SessionConnectEvent> {

    @Autowired
    private SocketSessionRegistry socketSessionRegistry;

    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());

        String user = sha.getNativeHeader("user").get(0);
        String sessionId = sha.getSessionId();
        socketSessionRegistry.registerSessionId(user, sessionId);
    }

}
