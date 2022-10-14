package com.boat.spring.data.jpa.tutorial.repository;

import com.boat.spring.data.jpa.tutorial.entity.Course;
import com.boat.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("JAVAA")
                .credit(5)
                .build();


        Teacher teacher =
                Teacher.builder()
                        .firstName("AAAA")
                        .lastName("BBBB")
                        .courses(List.of(course, courseJava))
                        .build();

        teacherRepository.save(teacher);
    }

}