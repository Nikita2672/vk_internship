package com.example.vk.audit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final AuditRepository auditRepository;

    public void log(String method, String path, String username, Boolean hasAccess) {
        AuditLog auditLog = AuditLog.builder()
                .hasAccess(true)
                .method(method)
                .path(path)
                .username(username)
                .hasAccess(hasAccess)
                .build();
        System.out.println("Time: " + LocalDateTime.now() + ", Method: " + method + ", Path: " + path + ", Username: " + username);
        auditRepository.save(auditLog);
    }
}
