package com.nadir.backend.controlers;

import com.nadir.backend.models.Grade;
import com.nadir.backend.models.Major;
import com.nadir.backend.services.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/majors")
public class MajorController {
    private final MajorService majorService;

    @GetMapping
    public List<Major> getAllMajors() {
        return majorService.getAllMajors();
    }

    @PostMapping
    public Major cmd(@RequestBody Major major) {
        return majorService.createMajor(major);
    }

    @GetMapping("/{id}")
    public Major getMajorById(@PathVariable Long id) {
        return majorService.getMajorById(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        Major major = majorService.getMajorById(id);
        if (major != null) {
            major.setDeleted(true);
            majorService.update(id, major);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public Major update(@PathVariable Long id, @RequestBody Major updated) {
        return  majorService.update(id, updated);
    }
}
