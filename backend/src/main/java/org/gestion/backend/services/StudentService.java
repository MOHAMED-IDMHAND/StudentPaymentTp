package org.gestion.backend.services;

import lombok.AllArgsConstructor;
import org.gestion.backend.entities.Student;
import org.gestion.backend.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Page<Student> findStudentsByFullName(String firstName, String lastName, Pageable pageable) {
        return studentRepository.findByFirstNameContainsIgnoreCase(firstName, pageable);
    }
    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            updatedStudent.setId(id);
            return studentRepository.save(updatedStudent);
        } else {
            return null;
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
