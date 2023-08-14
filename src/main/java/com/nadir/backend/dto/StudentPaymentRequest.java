package com.nadir.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPaymentRequest {
    private Long classroomId;
    private String month;
    private int year;
}
