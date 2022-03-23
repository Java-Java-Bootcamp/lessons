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

    // @NonNull
    public Student getStudentById(String id) {
        Student student = studentRepository.getById(id);

        if (student == null)
            throw new EntityNotFoundException("Student with id '" + id + "' was not found");

        return student;
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
