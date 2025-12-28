package com.nimblix.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nimbliex.entity.Assignment;
import com.nimbliex.entity.AssignmentSubmission;
import com.nimbliex.entity.Student;
import com.nimblix.dto.AssignmentTrackingResponseDTO;
import com.nimblix.dto.StudentTrackingDTO;
import com.nimblix.repository.AssignmentRepository;
import com.nimblix.repository.AssignmentSubmissionRepository;
import com.nimblix.repository.StudentRepository;

@Service
public class AssignmentService {


    private final AssignmentRepository assignmentRepo;
    private final AssignmentSubmissionRepository submissionRepo;
    private final StudentRepository studentRepo;

    public AssignmentService(AssignmentRepository assignmentRepo,
                             AssignmentSubmissionRepository submissionRepo,
                             StudentRepository studentRepo) {
        this.assignmentRepo = assignmentRepo;
        this.submissionRepo = submissionRepo;
        this.studentRepo = studentRepo;
    }

    public AssignmentTrackingResponseDTO getTracking(Long assignmentId) {

        Assignment assignment = assignmentRepo.findById(assignmentId).orElseThrow();
        List<Student> students = studentRepo.findByClassId(assignment.getClassId());

        List<StudentTrackingDTO> trackingList = new ArrayList<>();

        for (Student student : students) {

            Optional<AssignmentSubmission> submission =
                    submissionRepo.findByAssignmentIdAndStudentId(assignmentId, student.getId());

            String status;
            LocalDateTime submittedTime = null;

            if (submission.isPresent()) {
                submittedTime = submission.get().getSubmittedTime();
                if (submittedTime.isBefore(assignment.getDueDate())) {
                    status = "SUBMITTED";
                } else {
                    status = "LATE";
                }
            } else {
                if (LocalDateTime.now().isAfter(assignment.getDueDate())) {
                    status = "NOT_SUBMITTED";
                } else {
                    status = "PENDING";
                }
            }

            StudentTrackingDTO dto = new StudentTrackingDTO();
            dto.setStudentId(student.getId());
            dto.setStatus(status);
            dto.setSubmittedTime(submittedTime);

            trackingList.add(dto);
        }

        AssignmentTrackingResponseDTO response = new AssignmentTrackingResponseDTO();
        response.setAssignmentId(assignment.getId());
        response.setAssignmentName(assignment.getAssignmentName());
        response.setClassId(assignment.getClassId());
        response.setDueDate(assignment.getDueDate());
        response.setStudents(trackingList);

        return response;
    }

}
