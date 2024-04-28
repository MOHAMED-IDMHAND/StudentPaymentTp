package org.gestion.backend.web;

import lombok.AllArgsConstructor;
import org.gestion.backend.entities.Payment;
import org.gestion.backend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;

    @GetMapping("")
    public ResponseEntity<Page<Payment>> getAllPayments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Payment> payments = paymentService.getAllPayments( pageable);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/type")
    public ResponseEntity<Page<Payment>> getPaymentsByType(
            @RequestParam(defaultValue = "") String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Payment> payments = paymentService.getPaymentsByType(type, pageable);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/status")
    public ResponseEntity<Page<Payment>> getPaymentsByStatus(
            @RequestParam(defaultValue = "") String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Payment> payments = paymentService.getPaymentsByStatus(status, pageable);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/student")
    public ResponseEntity<Page<Payment>> getPaymentsByStudentId(
            @RequestParam(defaultValue = "") Long studentId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Payment> payments = paymentService.getPaymentsByStudentId(studentId, pageable);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(id, payment);
        if (updatedPayment != null) {
            return ResponseEntity.ok(updatedPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
