package com.example.vk.audit;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationEventPublisher;
import org.springframework.security.authorization.event.AuthorizationGrantedEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;


@Component
@RequiredArgsConstructor
public class AuthorizationEventPublisherImpl implements AuthorizationEventPublisher {

    private final ApplicationEventPublisher publisher;

    @Autowired
    private HttpServletRequest request;

    private static final String NEEDED_FILTER = "org.springframework.security.authorization.method.AuthorizationManagerBeforeMethodInterceptor";

    private static final String WHITE_LIST_URI = "/api/auth/";

    private static final String WEBSOCKET_URI = "/ws";

    @Override
    public <T> void publishAuthorizationEvent(Supplier<Authentication> authentication, T object, AuthorizationDecision decision) {
        if (decision == null) return;

        if (authentication.getClass().getName().startsWith(NEEDED_FILTER) ||
                request.getRequestURI().startsWith(WHITE_LIST_URI) ||
                request.getRequestURI().startsWith(WEBSOCKET_URI))
            publisher.publishEvent(new AuthorizationGrantedEvent<>(authentication, object, decision));
    }
}
