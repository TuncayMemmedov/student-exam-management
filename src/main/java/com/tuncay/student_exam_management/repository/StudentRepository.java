package com.tuncay.student_exam_management.repository;

import com.tuncay.student_exam_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {


}
