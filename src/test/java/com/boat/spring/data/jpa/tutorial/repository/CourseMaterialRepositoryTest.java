package com.boat.spring.data.jpa.tutorial.repository;

import com.boat.spring.data.jpa.tutorial.entity.Course;
import com.boat.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial() {

        Course course =
                Course.builder()
                        .title("DSA")
                        .credit(6)
                        .build();


        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("google.com")
                        .course(course)
                        .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials =
                repository.findAll();

        System.out.println("CourseMaterials = " + courseMaterials);
    }




}