package com.nimblix.dto;

import java.time.LocalDateTime;

public class StudentTrackingDTO {
	private Long studentId;
    private String status;
    private LocalDateTime submittedTime;
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getSubmittedTime() {
		return submittedTime;
	}
	public void setSubmittedTime(LocalDateTime submittedTime) {
		this.submittedTime = submittedTime;
	}
	


}
