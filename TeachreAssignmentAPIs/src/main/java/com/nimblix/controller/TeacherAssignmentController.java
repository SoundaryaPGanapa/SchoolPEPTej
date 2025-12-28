package com.nimblix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbliex.entity.Assignment;
import com.nimblix.dto.AssignmentTrackingResponseDTO;
import com.nimblix.repository.AssignmentRepository;
import com.nimblix.service.AssignmentService;

@RestController
@RequestMapping("/teacher/assignments")
public class TeacherAssignmentController {

	private final AssignmentRepository assignmentRepo;
    private final AssignmentService assignmentService;

    public TeacherAssignmentController(AssignmentRepository assignmentRepo,
                                       AssignmentService assignmentService) {
        this.assignmentRepo = assignmentRepo;
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentRepo.save(assignment);
    }

    @GetMapping("/{assignmentId}/tracking")
    public AssignmentTrackingResponseDTO getTracking(@PathVariable Long assignmentId) {
        return assignmentService.getTracking(assignmentId);
    }

}
