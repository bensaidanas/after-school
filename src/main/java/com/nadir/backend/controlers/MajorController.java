package com.nadir.backend.controlers;

import com.nadir.backend.models.Major;
import com.nadir.backend.services.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/majors")
public class MajorController {
    private final MajorService majorService;

    @PostMapping
    public Major cmd(@RequestBody Major major) {
        return majorService.createMajor(major);
    }

    @GetMapping("/{id}")
    public Major getMajorById(@PathVariable Long id) {
        return majorService.getMajorById(id);
    }
}
