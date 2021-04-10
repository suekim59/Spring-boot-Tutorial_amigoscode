package com.example.lecture.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
//@Component 이걸 쓸 수도 있지만 위에 것이 더 의미적으로 맞음
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent() {
        return studentRepository.findAll();
        //findAll()은 JPA가 제공하는 함수임
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);

    }
}
