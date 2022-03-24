package com.example.demo.services;

import com.example.demo.exceptios.EntityNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.rpostiory.StudentRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Collection;
import java.util.Objects;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final TransactionTemplate transactionTemplate;
    private final ApplicationContext context;

    public StudentService(StudentRepository studentRepository,
            PlatformTransactionManager transactionManager,
            ApplicationContext context) {
        this.studentRepository = studentRepository;
        transactionTemplate = new TransactionTemplate(transactionManager);
        this.context = context;
    }

    // @NonNull
    public Student getStudentById(String id) {
        Student student = studentRepository.getById(id);

        if (student == null)
            throw new EntityNotFoundException("Student with id '" + id + "' was not found");

        return student;
    }

    // @NonNull
    public Collection<Student> getStudents(String firstName) {
        if (firstName == null)
            return studentRepository.findAll();
        return studentRepository.findByFirstNameIgnoreCase(firstName);
    }

    // @NonNull
    public String createStudent(Student student) {
        return studentRepository.save(student).getId();
    }

    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(String id, String firstName, String lastName) {
        System.out.format("updateStudent(id: %s, firstName: %s, lastName: %s)\n", id, firstName, lastName);

        context.getBean(StudentService.class).updateFirstName(id, firstName);
//        context.getBean(StudentService.class).updateLastName(id, lastName);

//        updateFirstName(id, firstName);
        updateLastName(id, lastName);
    }

    public void updateStudentManual(String id, String firstName, String lastName) {
        System.out.format("updateStudentManual(id: %s, firstName: %s, lastName: %s)\n", id, firstName, lastName);

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {
                System.out.println("doInTransactionWithoutResult()");
                try {
                    updateFirstName(id, firstName);
                    updateLastName(id, lastName);
                } catch (Exception e) {
                    System.err.format("catch: %s", e.getMessage());
                    status.setRollbackOnly();
                }
            }
        });
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateFirstName(String id, String firstName) {
        System.out.format("updateFirstName(id: %s, firstName: %s)\n", id, firstName);

        if (firstName != null) {
            Student student = getStudentById(id);
            student.setFirstName(firstName);
            studentRepository.save(student);
        }
    }

    @Transactional
    public void updateLastName(String id, String lastName) {
        System.out.format("updateLastName(id: %s, lastName: %s)\n", id, lastName);

        Objects.requireNonNull(lastName, "lastName should not be null");
        Student student = getStudentById(id);
        student.setLastName(lastName);
        studentRepository.save(student);
    }

}
