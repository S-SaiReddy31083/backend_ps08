package com.example.demo.repository;

import com.example.demo.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
	
	long countByStatus(String status);

    List<Issue> findByCategory(String category);

    List<Issue> findTop5ByOrderByVotesDesc();
}
