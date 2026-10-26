package com.tuncay.student_exam_management.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDto {

    private Long id;

    private String fullName;

    private String email;

    private LocalDateTime createdAt;
}
