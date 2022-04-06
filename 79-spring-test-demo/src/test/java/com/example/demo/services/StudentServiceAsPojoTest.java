package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.rpostiory.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudentServiceAsPojoTest {

    private StudentRepository studentRepository;
    private StudentService studentService;

    @BeforeEach
    void init() {
        studentRepository = mock(StudentRepository.class);
        studentService = new StudentService(studentRepository);
    }

    @Test
    void shouldRetrieveStudentWhenGetKnownById() {
        Student expected = createStudent();

        when(studentRepository.getById(eq(expected.getId()))).thenReturn(expected);

        Student actual = studentService.getStudentById(expected.getId());
        assertThat(actual).isNotNull().isEqualTo(expected);
    }

    private static Student createStudent() {
        Student student = new Student();
        student.setId("cop");
        student.setFirstName("Oleg");
        student.setLastName("Cherednik");
        return student;
    }

}
