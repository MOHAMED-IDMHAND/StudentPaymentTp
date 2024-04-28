package org.gestion.backend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;

    // Getters and setters
}

