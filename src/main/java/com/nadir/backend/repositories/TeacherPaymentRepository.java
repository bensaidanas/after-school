package com.nadir.backend.repositories;

import com.nadir.backend.models.StudentPayment;
import com.nadir.backend.models.Teacher;
import com.nadir.backend.models.TeacherPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherPaymentRepository extends JpaRepository<TeacherPayment, Long> {
    List<TeacherPayment> findByTeacher(Teacher teacher);
}
