package com.tuncay.student_exam_management.repository;

import com.tuncay.student_exam_management.entity.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamResultRepository extends JpaRepository<ExamResult,Long> {

    List<ExamResult> findAllByOrderByScoreDesc();

}
