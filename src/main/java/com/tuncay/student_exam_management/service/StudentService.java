package com.tuncay.student_exam_management.service;

import com.tuncay.student_exam_management.dto.StudentRequestDto;
import com.tuncay.student_exam_management.dto.StudentResponseDto;
import com.tuncay.student_exam_management.entity.Student;
import com.tuncay.student_exam_management.exception.ResourceNotFoundException;
import com.tuncay.student_exam_management.mapper.StudentMapper;
import com.tuncay.student_exam_management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private Student getStudentfoundId(Long ExamResultId){
        return studentRepository.findById(ExamResultId).
                orElseThrow(() -> new ResourceNotFoundException("ExamResult not found"));
    }

    public StudentResponseDto createStudent(StudentRequestDto dto){

        Student student = StudentMapper.toEntity(dto);

        Student savedStudent = studentRepository.save(student);

        return StudentMapper.toResponse(savedStudent);
    }

    public List<StudentResponseDto> getAllStudents(){

        return studentRepository.
                findAll().
                stream().
                map(StudentMapper::toResponse).
                toList();
    }

    public StudentResponseDto getStudentById(Long id){

        Student student = getStudentfoundId(id);

        return StudentMapper.toResponse(student);
    }

    public StudentResponseDto updateStudent(Long id, StudentRequestDto dto){

        Student student = getStudentfoundId(id);

        StudentMapper.toUpdate(student, dto);

        Student savedStudent = studentRepository.save(student);

        return StudentMapper.toResponse(savedStudent);
    }

    public void deleteStudent(Long id){

        Student student = getStudentfoundId(id);

        studentRepository.delete(student);
    }
}
