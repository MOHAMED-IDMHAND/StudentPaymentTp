package org.gestion.backend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDTO {
    private Long id;
    private String code;
    private Date date;
    private String type;
    private String status;
    private String file;

}