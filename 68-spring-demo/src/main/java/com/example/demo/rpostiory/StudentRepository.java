package com.example.demo.rpostiory;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Collection<Student> findByFirstNameIgnoreCase(String firstName);

}
