package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.Issue;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.IssueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IssueRepository issueRepository;

    // 1️⃣ Get All Users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 2️⃣ Delete User
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    // 3️⃣ Change User Role
    @PutMapping("/users/{id}/role")
    public User updateUserRole(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElseThrow();
        user.setRole(updatedUser.getRole());
        return userRepository.save(user);
    }

    // 4️⃣ Get All Issues
    @GetMapping("/issues")
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    // 5️⃣ Close Issue
    @PutMapping("/issues/{id}/close")
    public Issue closeIssue(@PathVariable Long id) {
        Issue issue = issueRepository.findById(id).orElseThrow();
        issue.setStatus("CLOSED");
        return issueRepository.save(issue);
    }

    // 6️⃣ Delete Issue
    @DeleteMapping("/issues/{id}")
    public String deleteIssue(@PathVariable Long id) {
        issueRepository.deleteById(id);
        return "Issue deleted successfully";
    }
}