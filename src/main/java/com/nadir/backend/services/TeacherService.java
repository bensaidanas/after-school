package com.nadir.backend.services;

import com.nadir.backend.models.Teacher;
import com.nadir.backend.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAllByDeleted(Boolean.FALSE);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        Teacher existingTeacher = teacherRepository.findById(id).orElse(null);
        if (existingTeacher != null) {
            // Update fields as needed
            existingTeacher.setFirstName(updatedTeacher.getFirstName());
            existingTeacher.setLastName(updatedTeacher.getLastName());
            existingTeacher.setEmail(updatedTeacher.getEmail());
            existingTeacher.setPhoneNumber(updatedTeacher.getPhoneNumber());
            existingTeacher.setAddress(updatedTeacher.getAddress());
            existingTeacher.setSalaryBySession(updatedTeacher.getSalaryBySession());
            existingTeacher.setSubject(updatedTeacher.getSubject());
            // ... other fields
            return teacherRepository.save(existingTeacher);
        }
        return null; // Student not found
    }

    public Teacher deleteTeacher(Long id) {
        Teacher existingTeacher = teacherRepository.findById(id).orElse(null);
        if (existingTeacher != null) {
            existingTeacher.setDeleted(Boolean.TRUE);
            return teacherRepository.save(existingTeacher);
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
