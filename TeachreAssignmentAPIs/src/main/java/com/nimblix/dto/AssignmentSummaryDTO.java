package com.nimblix.dto;

public class AssignmentSummaryDTO {
	
	private Long assignmentId;
    private long submitted;
    private long late;
    private long notSubmitted;
	public Long getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}
	public long getSubmitted() {
		return submitted;
	}
	public void setSubmitted(long submitted) {
		this.submitted = submitted;
	}
	public long getLate() {
		return late;
	}
	public void setLate(long late) {
		this.late = late;
	}
	public long getNotSubmitted() {
		return notSubmitted;
	}
	public void setNotSubmitted(long notSubmitted) {
		this.notSubmitted = notSubmitted;
	}
	

}
