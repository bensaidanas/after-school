package com.nadir.backend.services;

import com.nadir.backend.dto.StudentPaymentRequest;
import com.nadir.backend.models.Classroom;
import com.nadir.backend.models.Student;
import com.nadir.backend.models.StudentPayment;
import com.nadir.backend.repositories.StudentPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentPaymentService {
    private final StudentPaymentRepository studentPaymentRepository;
    private final StudentService studentService;
    private final ClassroomService classroomService;

    public List<StudentPayment> getPaymentsByStudent(Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return studentPaymentRepository.findByStudent(student);
    }

    public boolean addPaymentForStudent(Long studentId, StudentPaymentRequest paymentRequest) {
        Student student = studentService.getStudentById(studentId);
        Classroom classroom = classroomService.getClassroomById(paymentRequest.getClassroomId());

        if (student != null && classroom != null) {
            StudentPayment newPayment = StudentPayment.builder()
                    .student(student)
                    .classroom(classroom)
                    .amount(classroom.getPrice())
                    .month(paymentRequest.getMonth())
                    .year(paymentRequest.getYear())
                    .isPaid(true) // Assuming payment is successful upon creation
                    .build();

            studentPaymentRepository.save(newPayment);
            return true;
        }
        return false;
    }
}
