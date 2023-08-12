package com.nadir.backend.repositories;

import com.nadir.backend.models.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Long> {
    // Custom queries if needed
}
