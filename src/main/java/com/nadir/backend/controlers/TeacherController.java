package com.nadir.backend.controlers;

import com.nadir.backend.models.Teacher;
import com.nadir.backend.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher student) {
        return teacherService.createTeacher(student);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
        return teacherService.updateTeacher(id, updatedTeacher);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        teacherService.deleteTeacher(id);
        return new ResponseEntity(HttpStatus.OK);
    }


//    @GetMapping("/{id}/enrolled-classes")
//    public List<Classroom> getEnrolledClasses(@PathVariable Long id) {
//        return studentService.getEnrolledClasses(id);
//    }
}
