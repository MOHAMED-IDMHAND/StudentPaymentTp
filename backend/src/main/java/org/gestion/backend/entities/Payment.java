package org.gestion.backend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.gestion.backend.enums.PaymentStatus;
import org.gestion.backend.enums.PaymentType;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder @ToString
public class Payment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String code;
        private Date date;
        private String type;
        private String status;
        private String file;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "student_id")
        private Student student;

        public Student getStudent() {
                return Student.builder()
                        .firstName(this.student.getFirstName())
                        .lastName(this.student.getLastName())
                        .email(this.student.getEmail())
                        .id(this.student.getId())
                        .major(this.student.getFirstName())
                .build();
        }
}
