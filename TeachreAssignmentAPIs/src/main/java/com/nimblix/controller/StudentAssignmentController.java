package com.nimblix.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbliex.entity.AssignmentSubmission;
import com.nimblix.repository.AssignmentSubmissionRepository;

@RestController
@RequestMapping("/student/assignments")
public class StudentAssignmentController {
	
	private final AssignmentSubmissionRepository submissionRepo;

    public StudentAssignmentController(AssignmentSubmissionRepository submissionRepo) {
        this.submissionRepo = submissionRepo;
    }

    @PostMapping("/{assignmentId}/submit")
    public AssignmentSubmission submitAssignment(
            @PathVariable Long assignmentId,
            @RequestBody Map<String, Long> request) {

        AssignmentSubmission submission = new AssignmentSubmission();
        submission.setAssignmentId(assignmentId);
        submission.setStudentId(request.get("studentId"));
        submission.setSubmittedTime(LocalDateTime.now());

        return submissionRepo.save(submission);
    }

}
