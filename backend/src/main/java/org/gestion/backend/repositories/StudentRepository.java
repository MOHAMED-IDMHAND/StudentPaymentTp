package org.gestion.backend.repositories;

import org.gestion.backend.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByMajor(String major, Pageable pageable);
    Page<Student> findByFirstNameContainsIgnoreCase(String firstName, Pageable pageable);
    Student findByCode(String code);
    Student findByEmail(String email);
}
