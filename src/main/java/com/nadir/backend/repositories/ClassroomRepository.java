package com.nadir.backend.repositories;

import com.nadir.backend.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    List<Classroom> findByDeletedFalse(); // Retrieve only undeleted classes
}
