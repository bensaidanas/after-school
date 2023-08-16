package com.nadir.backend.repositories;

import com.nadir.backend.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByDeleted(boolean deleted);
}
