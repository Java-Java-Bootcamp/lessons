package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleSpringApp {

    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example.demo");
        context.refresh();

        System.out.println("------------------");
        StudentService studentService = context.getBean(StudentService.class);
        Student student = studentService.getStudentById("cop");
        System.out.println(student);
    }

}
