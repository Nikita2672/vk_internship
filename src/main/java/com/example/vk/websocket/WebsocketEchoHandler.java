package com.example.vk.websocket;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@RequiredArgsConstructor
public class WebsocketEchoHandler extends TextWebSocketHandler {

    private final WebSocketSession clientSession;

    @Override
    protected void handleTextMessage(@NotNull WebSocketSession session, @NotNull TextMessage message) throws Exception {
        if (clientSession != null && clientSession.isOpen()) {
            clientSession.sendMessage(new TextMessage(message.getPayload()));
        }
    }
}