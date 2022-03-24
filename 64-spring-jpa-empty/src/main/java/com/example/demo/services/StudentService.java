package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.rpostiory.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(String id) {
        return studentRepository.getById(id);
    }

    public Collection<Student> getStudents() {
        return studentRepository.findAll();
    }

    public String createStudent(Student student) {
        return studentRepository.save(student).getId();
    }

    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

}
