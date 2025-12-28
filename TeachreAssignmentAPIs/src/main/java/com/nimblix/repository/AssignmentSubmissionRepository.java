package com.nimblix.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nimbliex.entity.AssignmentSubmission;

public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission, Long> {

	 Optional<AssignmentSubmission> findByAssignmentIdAndStudentId(Long assignmentId, Long studentId);

	    List<AssignmentSubmission> findByAssignmentId(Long assignmentId);
}
