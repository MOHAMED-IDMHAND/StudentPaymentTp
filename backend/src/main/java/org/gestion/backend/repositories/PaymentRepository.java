package org.gestion.backend.repositories;

import org.gestion.backend.entities.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Page<Payment> findByType(String type, Pageable pageable);
    Page<Payment> findByStatus(String status, Pageable pageable);
    Page<Payment> findByStudentId(Long studentId, Pageable pageable);
}