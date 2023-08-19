package com.nadir.backend.services;


import com.nadir.backend.models.Classroom;
import com.nadir.backend.models.Student;
import com.nadir.backend.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findByDeletedFalse();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            // Update fields as needed
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
            existingStudent.setGrade(updatedStudent.getGrade());
            existingStudent.setMajor(updatedStudent.getMajor());
            return studentRepository.save(existingStudent);
        }
        return null; // Student not found
    }

    public List<Classroom> getEnrolledClasses(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            return student.getClassrooms();
        }
        return null; // Student not found
    }

    public List<Classroom> getStudentClasses(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            return student.getClassrooms();
        }
        return null; // Student not found
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }


}
