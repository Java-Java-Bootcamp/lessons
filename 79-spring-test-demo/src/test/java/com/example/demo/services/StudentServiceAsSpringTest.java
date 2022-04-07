package com.example.demo.services;

import com.example.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Sql("/db/data.sql")
class StudentServiceAsSpringTest {

    @Autowired
    private StudentService studentService;

    @Test
    @Transactional
    void shouldRetrieveStudentWhenGetKnownById() {
        Student actual = studentService.getStudentById("cop");
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo("cop");
        assertThat(actual.getFirstName()).isEqualTo("Oleg");
        assertThat(actual.getLastName()).isEqualTo("Cherednik");
    }

    @Test
    @Transactional
    void shouldThrowEntityNotFoundExceptionWhenGetUnknownById() {
        assertThatThrownBy(() -> studentService.getStudentById("<unknown>"))
                .isExactlyInstanceOf(EntityNotFoundException.class);
    }

}
