package com.nadir.backend.services;

import com.nadir.backend.models.Grade;
import com.nadir.backend.models.Major;
import com.nadir.backend.repositories.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorService {
    private final MajorRepository majorRepository;

    public List<Major> getAllMajors() {
        List<Major> allMajors = majorRepository.findByDeletedFalse();

        if (allMajors.size() > 1) {
            return allMajors.stream().skip(1).collect(Collectors.toList());
        } else {
            return allMajors;
        }
    }

    public Major createMajor(Major major) {
        return majorRepository.save(major);
    }
    public Major getMajorById(Long id) {
        return majorRepository.findById(id).orElse(null);
    }

    public Major update(Long id, Major updated) {
        Major existingStudent = majorRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            // Update fields as needed
            existingStudent.setName(updated.getName());
            return majorRepository.save(existingStudent);
        }
        return null; // Student not found
    }
}
