package com.nadir.backend.repositories;

import com.nadir.backend.models.Grade;
import com.nadir.backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByGrade(Grade grade);
}
