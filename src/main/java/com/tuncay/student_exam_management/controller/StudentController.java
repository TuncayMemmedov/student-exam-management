package com.tuncay.student_exam_management.controller;

import com.tuncay.student_exam_management.dto.StudentRequestDto;
import com.tuncay.student_exam_management.dto.StudentResponseDto;
import com.tuncay.student_exam_management.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/api/students")
    public StudentResponseDto createStudent(@Valid @RequestBody StudentRequestDto dto){
        return studentService.createStudent(dto);
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping
    public StudentResponseDto getStudentById(@Valid Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequestDto dto){
        return studentService.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@Valid Long id){
        studentService.deleteStudent(id);
    }
}
