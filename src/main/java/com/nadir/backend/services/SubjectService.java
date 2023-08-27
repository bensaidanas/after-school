package com.nadir.backend.services;

import com.nadir.backend.models.Student;
import com.nadir.backend.models.Subject;
import com.nadir.backend.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findByDeletedFalse();
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject update(Long id, Subject updated) {
        Subject existingStudent = subjectRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            // Update fields as needed
            existingStudent.setName(updated.getName());
            return subjectRepository.save(existingStudent);
        }
        return null; // Student not found
    }
}
