package com.boat.spring.data.jpa.tutorial.repository;


import com.boat.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    //base on entity variable not table
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getFirstNameByEmailAddress(String emailId);

    //Native Query
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    //Native Named Param
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_student SET first_name = ?1 WHERE email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);
}
