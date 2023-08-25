package com.nadir.backend.controlers;

import com.nadir.backend.models.StudentPayment;
import com.nadir.backend.models.Teacher;
import com.nadir.backend.models.TeacherPayment;
import com.nadir.backend.services.TeacherPaymentService;
import com.nadir.backend.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher-payment")
public class TeacherPaymentController {
    private final TeacherPaymentService teacherPaymentService;

    @GetMapping("/teacher/{studentId}")
    public ResponseEntity<List<TeacherPayment>> getPaymentsByStudent(@PathVariable Long studentId) {
        List<TeacherPayment> payments = teacherPaymentService.getPaymentsByTeacher(studentId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @PostMapping
    public TeacherPayment createTeacher(@RequestBody TeacherPayment payment) {
        return teacherPaymentService.createTeacherPayment(payment);
    }

}
