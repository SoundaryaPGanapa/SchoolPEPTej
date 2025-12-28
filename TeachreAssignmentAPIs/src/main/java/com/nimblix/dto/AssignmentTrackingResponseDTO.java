package com.nimblix.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AssignmentTrackingResponseDTO {

	    private Long assignmentId;
	    private String assignmentName;
	    private Long classId;
	    private LocalDateTime dueDate;
	    private List<StudentTrackingDTO> students;
		public String getAssignmentName() {
			return assignmentName;
		}
		public void setAssignmentName(String assignmentName) {
			this.assignmentName = assignmentName;
		}
		public Long getAssignmentId() {
			return assignmentId;
		}
		public void setAssignmentId(Long assignmentId) {
			this.assignmentId = assignmentId;
		}
		public Long getClassId() {
			return classId;
		}
		public void setClassId(Long classId) {
			this.classId = classId;
		}
		public LocalDateTime getDueDate() {
			return dueDate;
		}
		public void setDueDate(LocalDateTime dueDate) {
			this.dueDate = dueDate;
		}
		public List<StudentTrackingDTO> getStudents() {
			return students;
		}
		public void setStudents(List<StudentTrackingDTO> students) {
			this.students = students;
		}
}
