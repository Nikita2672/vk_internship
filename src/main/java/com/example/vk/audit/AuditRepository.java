package com.example.vk.audit;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
public interface AuditRepository extends JpaRepository<AuditLog, Long> {

}
