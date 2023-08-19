package com.nadir.backend.services;

import com.nadir.backend.models.Grade;
import com.nadir.backend.models.Subject;
import com.nadir.backend.repositories.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade getGradeById(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }
}
