package com.nadir.backend.controlers;

import com.nadir.backend.models.Classroom;
import com.nadir.backend.models.Student;
import com.nadir.backend.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }

    @GetMapping("/{id}/enrolled-classes")
    public List<Classroom> getEnrolledClasses(@PathVariable Long id) {
        return studentService.getEnrolledClasses(id);
    }

    @GetMapping("/{studentId}/classes")
    public List<Classroom> getStudentClasses(@PathVariable Long studentId) {
        return studentService.getStudentClasses(studentId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            student.setDeleted(true);
            studentService.updateStudent(id, student);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
