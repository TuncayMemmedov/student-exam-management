package com.tuncay.student_exam_management.service;

import com.tuncay.student_exam_management.repository.ExamResultRepository;
import com.tuncay.student_exam_management.repository.StudentRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExamResultServiceTest {

    @Mock
    private ExamResultRepository examResultRepository;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private ExamResultService examResultService;

}