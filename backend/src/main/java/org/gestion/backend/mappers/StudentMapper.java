package org.gestion.backend.mappers;

import org.gestion.backend.DTOs.StudentDTO;
import org.gestion.backend.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        return dto;
    }
}