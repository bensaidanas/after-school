package com.nadir.backend.controlers;

import com.nadir.backend.models.Grade;
import com.nadir.backend.models.Subject;
import com.nadir.backend.services.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grades")
public class GradeController {
    private final GradeService gradeService;

    @GetMapping
    public List<Grade> getAllSubjects() {
        return gradeService.getAllGrades();
    }

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.createGrade(grade);
    }

    @GetMapping("/{id}")
    public Grade getGradeById(@PathVariable Long id) {
        return gradeService.getGradeById(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        Grade grade = gradeService.getGradeById(id);
        if (grade != null) {
            grade.setDeleted(true);
            gradeService.update(id, grade);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public Grade update(@PathVariable Long id, @RequestBody Grade updated) {
        return  gradeService.update(id, updated);
    }

}
