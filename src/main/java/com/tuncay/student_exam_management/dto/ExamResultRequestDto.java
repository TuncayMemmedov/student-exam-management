package com.tuncay.student_exam_management.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamResultRequestDto {

    @NotBlank(message = "Subject boş ola bilməz")
    private String subject;

    @NotNull(message = "Score boş ola bilməz")
    @Min(value = 0, message = "Score minimum 0 olmalıdır")
    @Max(value = 100, message = "Score maksimum 100 olmalıdır")
    private Integer score;

    private LocalDate examDate;

}
