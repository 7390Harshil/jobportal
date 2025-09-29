package com.zidio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio.DTO.RecruiterDTO;
import com.zidio.Entity.Recruiter;
import com.zidio.Service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<Recruiter> saveRecruiter(@RequestBody RecruiterDTO dto) {
        return ResponseEntity.ok(recruiterService.createOrUpdateRecruiter(dto));
    }

    @GetMapping("/{recruiterEmail}")
    public ResponseEntity<Recruiter> getRecruiter(@PathVariable String recruiterEmail) {
        return ResponseEntity.ok(recruiterService.getRecruiterByEmail(recruiterEmail));
    }
}
