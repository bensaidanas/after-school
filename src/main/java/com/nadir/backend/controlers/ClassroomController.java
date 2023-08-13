package com.nadir.backend.controlers;

import com.nadir.backend.models.Classroom;
import com.nadir.backend.models.Student;
import com.nadir.backend.services.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    @PostMapping
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return classroomService.createClassroom(classroom);
    }

    @GetMapping("/{id}")
    public Classroom getClassroomById(@PathVariable Long id) {
        return classroomService.getClassroomById(id);
    }

    @GetMapping
    public List<Classroom> getAllClasses() {
        return classroomService.getAllClasses();
    }

    @PostMapping("/{classroomId}/students/{studentId}")
    public Classroom addStudentToClass(
            @PathVariable Long classroomId,
            @PathVariable Long studentId
    ) {
        return classroomService.addStudentToClass(classroomId, studentId);
    }

//    @GetMapping("/{classroomId}/students")
//    public List<Student> getStudentsInClass(@PathVariable Long classroomId) {
//        return classroomService.getStudentsInClass(classroomId);
//    }

    @GetMapping("/{classroomId}/non-enrolled-students")
    public List<Student> getNonEnrolledStudents(@PathVariable Long classroomId) {
        return classroomService.getStudentsNotInClassroom(classroomId);
    }
}
