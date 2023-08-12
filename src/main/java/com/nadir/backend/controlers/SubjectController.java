package com.nadir.backend.controlers;

import com.nadir.backend.models.Subject;
import com.nadir.backend.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }
}
