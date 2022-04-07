package com.example.demo.rpostiory;

import com.example.demo.model.Student;
import org.hibernate.Hibernate;
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
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    void shouldRetrieveStudentWhenGetKnownById() {
        Student actual = studentRepository.getById("cop");
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo("cop");
        assertThat(actual.getFirstName()).isEqualTo("Oleg");
        assertThat(actual.getLastName()).isEqualTo("Cherednik");
    }

    @Test
    @Transactional
    void shouldThrowEntityNotFoundExceptionWhenGetUnknownById() {
        assertThatThrownBy(() -> Hibernate.unproxy(studentRepository.getById("<unknown>")))
                .isExactlyInstanceOf(EntityNotFoundException.class);
    }

}
