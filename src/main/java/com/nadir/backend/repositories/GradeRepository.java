package com.nadir.backend.repositories;

import com.nadir.backend.models.Grade;
import com.nadir.backend.models.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByDeletedFalse();

}
