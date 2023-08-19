package com.nadir.backend.services;

import com.nadir.backend.models.Classroom;
import com.nadir.backend.models.Grade;
import com.nadir.backend.models.Student;
import com.nadir.backend.repositories.ClassroomRepository;
import com.nadir.backend.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom getClassroomById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    public List<Classroom> getAllClasses() {
        return classroomRepository.findByDeletedFalse();
    }

    public Classroom addStudentToClass(Long classroomId, Long studentId) {
        Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
        Student student = studentService.getStudentById(studentId);
        if (classroom != null && student != null) {
            classroom.getStudents().add(student);
            return classroomRepository.save(classroom);
        }

        return null; // Classroom or student not found
    }

    public List<Student> getUndeletedStudentsInClass(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
        if (classroom != null) {
            return classroom.getStudents().stream()
                    .filter(student -> !student.isDeleted()) // Filter out deleted students
                    .collect(Collectors.toList());
        }
        return null; // Classroom not found
    }


    public List<Student> getStudentsNotInClassroom(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
        if (classroom != null) {
            Grade grade = classroom.getGrade();
            List<Student> studentsInGrade = studentRepository.findByGradeAndDeletedFalse(grade);

            List<Student> studentsInClassroom = classroom.getStudents();
            studentsInGrade.removeAll(studentsInClassroom);

            return studentsInGrade;
        }
        return null; // Classroom not found
    }

    public void deleteClassAndUnenrollStudents(Long classId) {
        Classroom classroom = classroomRepository.findById(classId).orElse(null);
        if (classroom != null) {
            List<Student> students = classroom.getStudents();
            for (Student student : students) {
                student.getClassrooms().remove(classroom);
            }
            classroom.setStudents(new ArrayList<>()); // Clear the students list
            classroomRepository.save(classroom);
        }
    }

    public Classroom updateClassroom(Long id, Classroom updatedClassroom) {
        Classroom existingClassroom = classroomRepository.findById(id).orElse(null);
        if (existingClassroom != null) {
            // Update fields as needed
            existingClassroom.setName(updatedClassroom.getName());
            existingClassroom.setTeacher(updatedClassroom.getTeacher());
            existingClassroom.setPrice(updatedClassroom.getPrice());
            existingClassroom.setSessionNumber(updatedClassroom.getSessionNumber());

            return classroomRepository.save(existingClassroom);
        }
        return null; // Student not found
    }

    public void unenrollStudentFromClass(Long classroomId, Long studentId) {
        Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
        if (classroom != null) {
            List<Student> students = classroom.getStudents();
            students.removeIf(student -> student.getId().equals(studentId));
            classroomRepository.save(classroom);
        }
    }
}
