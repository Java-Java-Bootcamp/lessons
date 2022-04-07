package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.rpostiory.StudentRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // @NonNull
    public Student getStudentById(String id) {
        return (Student)Hibernate.unproxy(studentRepository.getById(id));
    }

    // @NonNull
    public Collection<Student> getStudents() {
        return studentRepository.findAll();
    }

    // @NonNull
    public String createStudent(Student student) {
        return studentRepository.save(student).getId();
    }

    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

}
