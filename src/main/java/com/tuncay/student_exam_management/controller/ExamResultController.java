package com.tuncay.student_exam_management.controller;


import com.tuncay.student_exam_management.dto.ExamResultRequestDto;
import com.tuncay.student_exam_management.dto.ExamResultResponseDto;
import com.tuncay.student_exam_management.service.ExamResultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examresult")
@RequiredArgsConstructor
public class ExamResultController {

    private final ExamResultService examResultService;

    @PostMapping("/student/{studentId}")
    public ExamResultResponseDto createExamResult(@Valid @RequestBody ExamResultRequestDto dto, @PathVariable Long studentId){
        return examResultService.createExamResult(dto,studentId);
    }

    @GetMapping
    public List<ExamResultResponseDto> getAllExamResults(){
        return examResultService.getAllExamResults();
    }

    @GetMapping("/{id}")
    public ExamResultResponseDto getExamResultById(@PathVariable Long id){
        return examResultService.getExamResultById(id);
    }

    @PutMapping("/{id}")
    public ExamResultResponseDto updateExamResult(@PathVariable Long id, @Valid @RequestBody ExamResultRequestDto dto){
        return examResultService.updateExamResult(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deleteExamResult(@PathVariable Long id){
        examResultService.deleteExamResult(id);
    }
}
