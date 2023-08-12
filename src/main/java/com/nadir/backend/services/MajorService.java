package com.nadir.backend.services;

import com.nadir.backend.models.Major;
import com.nadir.backend.repositories.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MajorService {
    private final MajorRepository majorRepository;
    public Major createMajor(Major major) {
        return majorRepository.save(major);
    }
    public Major getMajorById(Long id) {
        return majorRepository.findById(id).orElse(null);
    }
}
