package com.example.lecture.student;

import com.example.lecture.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

//api에 필요한 모든 리소스를 담을 거임
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    //add constructor하기
    //아래의 서비스를 injection해주는 annotation
    //이게 없다면 this.studentService = new studentService가 되어야 함. 인스턴스가 없기 때문에
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }


    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }


}
