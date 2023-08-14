package com.nadir.backend.repositories;

import com.nadir.backend.models.Student;
import com.nadir.backend.models.StudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentPaymentRepository extends JpaRepository<StudentPayment, Long> {
    List<StudentPayment> findByStudent(Student student);
}
