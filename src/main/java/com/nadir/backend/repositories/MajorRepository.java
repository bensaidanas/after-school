package com.nadir.backend.repositories;

import com.nadir.backend.models.Major;
import com.nadir.backend.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major, Long> {
    List<Major> findByDeletedFalse();

}
