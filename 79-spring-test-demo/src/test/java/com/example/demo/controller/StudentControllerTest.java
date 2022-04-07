package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = StudentController.class)
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void shouldRetrieveHttpStatus200WithStudentInBody() throws Exception {
        Student expected = createStudent();
        given(studentService.getStudentById(eq(expected.getId()))).willReturn(expected);

        mockMvc.perform(get("/students/{id}", expected.getId())
                .accept(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.id", is("cop")))
               .andExpect(jsonPath("$.firstName", is("Oleg")))
               .andExpect(jsonPath("$.lastName", is("Cherednik")));
    }

    private static Student createStudent() {
        Student student = new Student();
        student.setId("cop");
        student.setFirstName("Oleg");
        student.setLastName("Cherednik");
        return student;
    }

}
