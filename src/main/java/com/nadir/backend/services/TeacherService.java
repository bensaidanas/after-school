package com.nadir.backend.services;

import com.nadir.backend.models.Classroom;
import com.nadir.backend.models.Student;
import com.nadir.backend.models.Teacher;
import com.nadir.backend.repositories.StudentRepository;
import com.nadir.backend.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        Teacher existingStudent = teacherRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            // Update fields as needed
            existingStudent.setFirstName(updatedTeacher.getFirstName());
            existingStudent.setLastName(updatedTeacher.getLastName());
            // ... other fields
            return teacherRepository.save(existingStudent);
        }
        return null; // Student not found
    }

//    public List<Classroom> getEnrolledClasses(Long teacherId) {
//        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
//        if (teacher != null) {
//            return teacher.getClassrooms();
//        }
//        return null; // Student not found
//    }
}
