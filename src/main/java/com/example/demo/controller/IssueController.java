package com.example.demo.controller;

import com.example.demo.entity.Issue;
import com.example.demo.service.IssueService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
@CrossOrigin(origins = "*")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    // 1. Raise Issue
    @PostMapping(consumes = "multipart/form-data")
    public Issue createIssue(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String category,
            @RequestParam(required = false) MultipartFile image,
            @RequestParam(required = false) MultipartFile video
    ) {
        return issueService.saveIssueWithMedia(title, description, category, image, video);
    }

    // 2. View All Issues
    @GetMapping
    public List<Issue> getIssues() {
        return issueService.getAllIssues();
    }

    // 3. Vote Issue
    @PutMapping("/{id}/vote")
    public Issue voteIssue(@PathVariable Long id) {
        return issueService.voteForIssue(id);
    }

    // 4. Top Priority Issues (NEW)
    @GetMapping("/top")
    public List<Issue> getTopIssues() {
        return issueService.getTopIssues();
    }

    // 5. Update Issue Status (NEW)
    @PutMapping("/{id}/status")
    public Issue updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return issueService.updateStatus(id, status);
    }
}
