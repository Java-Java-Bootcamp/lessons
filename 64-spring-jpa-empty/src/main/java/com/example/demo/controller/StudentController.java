package com.example.demo.controller;

import com.example.demo.exceptios.EntityNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students")
    public Collection<Student> getStudents() {
        return studentService.getStudents();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/students", produces = "application/text")
    public String createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
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
