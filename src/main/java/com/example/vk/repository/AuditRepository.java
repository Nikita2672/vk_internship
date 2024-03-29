package com.example.vk.repository;

import com.example.vk.audit.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, Long> {
}
