package com.example.vk.audit;

import com.example.vk.repository.AuditRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.event.AuthorizationEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@RequiredArgsConstructor
public class AuthorizationEventListener {

    private static final String ERROR_URI = "/error";

    private final AuditRepository auditRepository;

    @Autowired
    private HttpServletRequest request;

    @EventListener
    public void auditEventHappened(AuthorizationEvent authorizationEvent) {
        AuthorizationDecision decision = authorizationEvent.getAuthorizationDecision();
        String name = authorizationEvent.getAuthentication().get().getName();

        if (!request.getRequestURI().equals(ERROR_URI)) {
            saveAudit(request.getRemoteAddr(), name, request.getRequestURI(),
                    request.getMethod(), decision.isGranted());
        }
    }

    private void saveAudit(String ip, String username, String endPoint, String method, boolean status) {
        AuditEntity audit = AuditEntity.builder()
                .ip(ip)
                .username(username)
                .endpoint(endPoint)
                .method(method)
                .status(!status ? "DENIED" : "GRANTED")
                .time(LocalDateTime.now())
                .build();
        auditRepository.save(audit);
    }

}
