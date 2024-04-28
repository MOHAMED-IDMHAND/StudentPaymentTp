package org.gestion.backend.services;

import lombok.AllArgsConstructor;
import org.gestion.backend.entities.Payment;
import org.gestion.backend.repositories.PaymentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentService {


    private PaymentRepository paymentRepository;

    public Page<Payment> getAllPayments( Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }
    public Page<Payment> getPaymentsByType(String type, Pageable pageable) {
        return paymentRepository.findByType(type, pageable);
    }

    public Page<Payment> getPaymentsByStatus(String status, Pageable pageable) {
        return paymentRepository.findByStatus(status, pageable);
    }

    public Page<Payment> getPaymentsByStudentId(Long studentId, Pageable pageable) {
        return paymentRepository.findByStudentId(studentId, pageable);
    }
    public Payment getPaymentById(Long id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.orElse(null);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            updatedPayment.setId(id);
            return paymentRepository.save(updatedPayment);
        } else {
            return null;
        }
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
