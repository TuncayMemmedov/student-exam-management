package com.tuncay.student_exam_management.mapper;

import com.tuncay.student_exam_management.dto.ExamResultRequestDto;
import com.tuncay.student_exam_management.dto.ExamResultResponseDto;
import com.tuncay.student_exam_management.entity.ExamResult;
import com.tuncay.student_exam_management.entity.Student;

public class ExamResultMapper {

    public static ExamResult toEntity(ExamResultRequestDto dto, Student student){
        return ExamResult.builder().
                subject(dto.getSubject()).
                score(dto.getScore()).
                examDate(dto.getExamDate()).
                student(student).
                build();
    }

    public static ExamResultResponseDto toResponse(ExamResult result){
        return ExamResultResponseDto.builder().
                id(result.getId()).
                subject(result.getSubject()).
                score(result.getScore()).
                examDate(result.getExamDate()).
                studentId(result.getId()).
                build();
    }

    public static void toUpdate(ExamResult result, ExamResultRequestDto dto){
        result.setExamDate(dto.getExamDate());
        result.setScore(dto.getScore());
        result.setSubject(dto.getSubject());
    }
}
