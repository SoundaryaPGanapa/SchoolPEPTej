package com.nimblix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimbliex.entity.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}
