package com.eternal.design.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class STOMPDisconnectEventListener implements ApplicationListener<SessionDisconnectEvent> {

    @Autowired
    private SocketSessionRegistry socketSessionRegistry;

    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        String sessionId = sessionDisconnectEvent.getSessionId();
        socketSessionRegistry.unregisterSessionId(sessionId);
    }
}
