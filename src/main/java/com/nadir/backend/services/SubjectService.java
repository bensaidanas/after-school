package com.nadir.backend.services;

import com.nadir.backend.models.Major;
import com.nadir.backend.models.Subject;
import com.nadir.backend.repositories.MajorRepository;
import com.nadir.backend.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }
}
