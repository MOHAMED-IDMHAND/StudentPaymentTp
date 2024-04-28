package org.gestion.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder @ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<>();


}

