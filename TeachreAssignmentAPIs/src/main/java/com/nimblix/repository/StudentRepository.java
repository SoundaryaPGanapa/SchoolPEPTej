package com.nimblix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimbliex.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByClassId(Long classId);
}
