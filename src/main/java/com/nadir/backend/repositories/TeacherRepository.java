package com.nadir.backend.repositories;

import com.nadir.backend.models.Classroom;
import com.nadir.backend.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByDeleted(boolean deleted);

    @Query("SELECT c FROM Classroom c WHERE c.teacher.id = :teacherId")
    List<Classroom> findClassesByTeacherId(Long teacherId);
}
