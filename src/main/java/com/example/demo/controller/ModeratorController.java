package com.example.demo.controller;

import com.example.demo.entity.Issue;
import com.example.demo.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/moderator")
@CrossOrigin(origins = "*")
public class ModeratorController {

    @Autowired
    private IssueRepository issueRepository;

    // 1. Get all issues
    @GetMapping("/issues")
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    // 2. Update issue status
    @PutMapping("/issues/{id}/status")
    public Issue updateIssueStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Issue issue = issueRepository.findById(id).orElseThrow();
        issue.setStatus(body.get("status"));
        return issueRepository.save(issue);
    }

    // 3. Delete issue
    @DeleteMapping("/issues/{id}")
    public void deleteIssue(@PathVariable Long id) {
        issueRepository.deleteById(id);
    }

    // 4. Moderator stats
    @GetMapping("/stats")
    public Map<String, Long> getStats() {
        Map<String, Long> map = new HashMap<>();
        map.put("totalIssues", issueRepository.count());
        map.put("openIssues", issueRepository.countByStatus("OPEN"));
        map.put("inProgressIssues", issueRepository.countByStatus("IN_PROGRESS"));
        map.put("resolvedIssues", issueRepository.countByStatus("RESOLVED"));
        return map;
    }
}