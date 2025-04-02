package com.swarna.jobtracker.controller;

import com.swarna.jobtracker.entity.Interview;
import com.swarna.jobtracker.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping
    public ResponseEntity<Interview> create(@RequestBody Interview interview) {
        return ResponseEntity.ok(interviewService.saveInterview(interview));
    }

    @GetMapping("/application/{appId}")
    public ResponseEntity<List<Interview>> getByApp(@PathVariable Long appId) {
        return ResponseEntity.ok(interviewService.getInterviewsByApplication(appId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interview> getById(@PathVariable Long id) {
        return interviewService.getInterviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        interviewService.deleteInterview(id);
        return ResponseEntity.noContent().build();
    }
}