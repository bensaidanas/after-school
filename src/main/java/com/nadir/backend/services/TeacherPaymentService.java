package com.nadir.backend.services;

import com.nadir.backend.models.Student;
import com.nadir.backend.models.StudentPayment;
import com.nadir.backend.models.Teacher;
import com.nadir.backend.models.TeacherPayment;
import com.nadir.backend.repositories.TeacherPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherPaymentService {
    private final TeacherPaymentRepository teacherPaymentRepository;
    private final TeacherService teacherService;


    public List<TeacherPayment> getPaymentsByTeacher(Long studentId) {
        Teacher teacher = teacherService.getTeacherById(studentId);
        return teacherPaymentRepository.findByTeacher(teacher);
    }


    public TeacherPayment createTeacherPayment(TeacherPayment teacher) {
        return teacherPaymentRepository.save(teacher);
    }
}
