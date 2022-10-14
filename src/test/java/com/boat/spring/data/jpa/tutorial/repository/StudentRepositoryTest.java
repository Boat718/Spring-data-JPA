package com.boat.spring.data.jpa.tutorial.repository;

import com.boat.spring.data.jpa.tutorial.entity.Guardian;
import com.boat.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("bbbb@gmail.com")
                .firstName("C")
                .lastName("D")
//                .guardianName("IDK")
//                .guardianEmail("ALO@gmial.com")
//                .guardianMobile("12323")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("ALO@gmial.com")
                .name("IDK")
                .mobile("1233")
                .build();

        Student student = Student.builder()
                .emailId("ASD@gmail.com")
                .firstName("AACC")
                .lastName("DA")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {

        List<Student> students = studentRepository.findByFirstName("CC");

        System.out.println("students = " + students);

    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students = studentRepository.findByFirstNameContaining("A");

        System.out.println("students = " + students);

    }

    @Test
    public void printStudentBasedOnGuardianName() {

        List<Student> students = studentRepository.findByGuardianName("IDK");

        System.out.println("students = " + students);

    }

    @Test
    public void printStudentByEmail() {

        Student students = studentRepository.getStudentByEmailAddress("bbbb@gmail.com");

        System.out.println("students = " + students);

    }

    @Test
    public void printStudentFirstNameByEmail() {

        String firstName = studentRepository.getFirstNameByEmailAddress("bbbb@gmail.com");

        System.out.println("students = " + firstName);

    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "aaa@gmail.com"
                );

        System.out.println("Student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "aaa@gmail.com"
                );

        System.out.println("Student = " + student);
    }


    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "updateName",
                "aaa@gmail.com"
        );
    }
}