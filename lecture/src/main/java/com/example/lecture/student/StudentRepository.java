package com.example.lecture.student;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

@Repository
//responsible for data access
public interface StudentRepository
        extends JpaRepository<Student,Long> {
    //이런식으로 extends 시켜놓으면
    //JPA가 알아서 메소드 다 가지고 있음.
    //JPA 쓰지 않을때는 다 만들었건만... 기본적인 함수는 다 가지고 있음

    //STUDENT는 우리가 entity 어노테이션 부여한 클래스
    @Query("SELECT s FROM Student s WHERE s.email=?1")
    Optional<Student> findStudentEmail(String email);

}
