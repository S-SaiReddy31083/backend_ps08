package com.example.demo.service;

import com.example.demo.entity.Issue;
import com.example.demo.repository.IssueRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import java.io.IOException;

import java.util.List;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public Issue saveIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Issue voteForIssue(Long id) {
        Issue issue = issueRepository.findById(id).orElseThrow();
        issue.setVotes(issue.getVotes() + 1);
        return issueRepository.save(issue);
    }

    public List<Issue> getTopIssues() {
        return issueRepository.findTop5ByOrderByVotesDesc();
    }

    public Issue updateStatus(Long id, String status) {
        Issue issue = issueRepository.findById(id).orElseThrow();
        issue.setStatus(status);
        return issueRepository.save(issue);
    }
    public Issue saveIssueWithMedia(String title, String description, String category, String location,
            MultipartFile image, MultipartFile video) {

Issue issue = new Issue();
issue.setTitle(title);
issue.setDescription(description);
issue.setCategory(category);
issue.setLocation(location);

try {
// Create uploads folder if not exists
Path uploadPath = Paths.get("uploads");
if (!Files.exists(uploadPath)) {
Files.createDirectories(uploadPath);
}

// Save Image
if (image != null && !image.isEmpty()) {
String imageName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
Path imagePath = uploadPath.resolve(imageName);
Files.copy(image.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
issue.setImageUrl("/uploads/" + imageName);
}

// Save Video
if (video != null && !video.isEmpty()) {
String videoName = System.currentTimeMillis() + "_" + video.getOriginalFilename();
Path videoPath = uploadPath.resolve(videoName);
Files.copy(video.getInputStream(), videoPath, StandardCopyOption.REPLACE_EXISTING);
issue.setVideoUrl("/uploads/" + videoName);
}

} catch (IOException e) {
e.printStackTrace();
}

return issueRepository.save(issue);
}
}
