package com.tuncay.student_exam_management.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamResultResponseDto {

    private Long id;

    private String subject;

    private Integer score;

    private LocalDate examDate;

    private Long studentId;
}
