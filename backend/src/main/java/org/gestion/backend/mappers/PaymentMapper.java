package org.gestion.backend.mappers;

import org.gestion.backend.DTOs.PaymentDTO;
import org.gestion.backend.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public PaymentDTO toDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setCode(payment.getCode());
        dto.setDate(payment.getDate());
        dto.setType(payment.getType().toString());
        dto.setStatus(payment.getStatus().toString());
        return dto;
    }
}