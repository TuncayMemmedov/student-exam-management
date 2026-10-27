package com.tuncay.student_exam_management.service;

import com.tuncay.student_exam_management.dto.ExamResultRequestDto;
import com.tuncay.student_exam_management.dto.ExamResultResponseDto;
import com.tuncay.student_exam_management.entity.ExamResult;
import com.tuncay.student_exam_management.entity.Student;
import com.tuncay.student_exam_management.exception.ResourceNotFoundException;
import com.tuncay.student_exam_management.mapper.ExamResultMapper;
import com.tuncay.student_exam_management.repository.ExamResultRepository;
import com.tuncay.student_exam_management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamResultService {

    private final ExamResultRepository examResultRepository;
    private final StudentRepository studentRepository;

    private Student StudentfindById(Long id){
        return studentRepository.
                findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    private ExamResult ExamResultfindById(Long id){
        return examResultRepository.
                findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    public ExamResultResponseDto createExamResult(ExamResultRequestDto dto, Long studentId){

        Student student = StudentfindById(studentId);

        ExamResult result = ExamResultMapper.toEntity(dto, student);

        ExamResult saved = examResultRepository.save(result);

        return ExamResultMapper.toResponse(saved);
    }

    public List<ExamResultResponseDto> getAllExamResults(){

        return examResultRepository.
                findAll().
                stream().
                map(ExamResultMapper::toResponse).
                toList();
    }

    public ExamResultResponseDto getExamResultById(Long id){

        ExamResult result = ExamResultfindById(id);

        return ExamResultMapper.toResponse(result);
    }

    public ExamResultResponseDto updateExamResult(Long id, ExamResultRequestDto dto){

        ExamResult result = ExamResultfindById(id);

        ExamResultMapper.toUpdate(result, dto);

        ExamResult saved = examResultRepository.save(result);

        return ExamResultMapper.toResponse(saved);
    }

    public void deleteExamResult(Long id){

        ExamResult result = ExamResultfindById(id);

        examResultRepository.delete(result);
    }
}
