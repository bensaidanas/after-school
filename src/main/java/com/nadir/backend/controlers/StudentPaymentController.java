package com.nadir.backend.controlers;

import com.nadir.backend.dto.StudentPaymentRequest;
import com.nadir.backend.models.StudentPayment;
import com.nadir.backend.services.StudentPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-payments")
@RequiredArgsConstructor
public class StudentPaymentController {
    private final StudentPaymentService studentPaymentService;

    @GetMapping("/students/{studentId}")
    public ResponseEntity<List<StudentPayment>> getPaymentsByStudent(@PathVariable Long studentId) {
        List<StudentPayment> payments = studentPaymentService.getPaymentsByStudent(studentId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @PostMapping("/students/{studentId}")
    public ResponseEntity<StudentPaymentRequest> addPaymentForStudent(
            @PathVariable Long studentId,
            @RequestBody StudentPaymentRequest paymentRequest
    ) {
        boolean paymentAdded = studentPaymentService.addPaymentForStudent(studentId, paymentRequest);
        return new ResponseEntity<>(paymentRequest, HttpStatus.CREATED);
    }
}
