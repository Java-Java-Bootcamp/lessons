package com.example.demo.services;

import com.example.demo.exceptios.EntityNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.rpostiory.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
// @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(String id) {
        Student student = studentRepository.getStudentById(id);

        if (student == null)
            throw new EntityNotFoundException("Student with id '" + id + "' was not found");

        return student;
    }

    public Collection<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public String createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    public void deleteStudentById(String id) {
        studentRepository.deleteStudentById(id);
    }

}
