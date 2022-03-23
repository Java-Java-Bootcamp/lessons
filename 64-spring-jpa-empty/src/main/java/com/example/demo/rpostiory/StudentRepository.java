package com.example.demo.rpostiory;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    private Map<String, Student> students = new HashMap<>(Map.of(
            "cop", new Student("cop", "Oleg", "Cherednik"),
            "zia", new Student("zia", "Ilya", "Zakharchuk"),
            "bio", new Student("bio", "Ivan", "Bokov")));

    public Student getStudentById(String id) {
        return students.get(id);
    }

    public Collection<Student> getStudents() {
        return students.values();
    }

    public String createStudent(Student student) {
        students.put(student.getId(), student);
        return student.getId();
    }

    public void deleteStudentById(String id) {
        students.remove(id);
    }

}
