package com.tuncay.student_exam_management.mapper;

import com.tuncay.student_exam_management.dto.StudentRequestDto;
import com.tuncay.student_exam_management.dto.StudentResponseDto;
import com.tuncay.student_exam_management.entity.Student;

public class StudentMapper {

    public static Student toEntity(StudentRequestDto dto){

        return Student.builder().
                fullName(dto.getFullName()).
                email(dto.getEmail()).
                build();
    }

    public static StudentResponseDto toResponse(Student student){

        return StudentResponseDto.builder().
                id(student.getId()).
                fullName(student.getFullName()).
                createdAt(student.getCreatedAt()).
                email(student.getEmail()).
                build();
    }

    public static void toUpdate(Student student, StudentRequestDto dto){

        student.setEmail(dto.getEmail());
        student.setFullName(dto.getFullName());
    }
}
