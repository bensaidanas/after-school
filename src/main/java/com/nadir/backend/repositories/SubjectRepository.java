package com.nadir.backend.repositories;

import com.nadir.backend.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByDeletedFalse();
}
