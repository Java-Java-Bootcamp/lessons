package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // TODO Actual it should return StudentDto, but I had a problem to register Json converter in SpringTest
    @GetMapping("/students/{id}")
    public ResponseEntity<String> getStudentById(@PathVariable("id") String id) throws JsonProcessingException {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(new ObjectMapper().writeValueAsString(student.createDto()));
    }

    @GetMapping("/students")
    public Collection<StudentDto> getStudents() {
        return studentService.getStudents().stream()
                             .map(Student::createDto)
                             .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/students", produces = MediaType.TEXT_PLAIN_VALUE)
    public String createStudent(@RequestBody StudentDto student) {
        return studentService.createStudent(new Student(student));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable("id") String id) {
        studentService.deleteStudentById(id);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> entityNotFoundErrorHandler(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    public static class Error {
    }

}
