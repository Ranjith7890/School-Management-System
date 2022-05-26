package com.schooolmanagement.schoolmanagementsystem.repostorytest;

import com.schooolmanagement.schoolmanagementsystem.model.Address;
import com.schooolmanagement.schoolmanagementsystem.model.Student;
import com.schooolmanagement.schoolmanagementsystem.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.hibernate.annotations.OrderBy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.repository.query.Param;

@SpringBootTest
public class RepositoryTest {

  @Autowired
     private StudentRepository studentRepository;

    @Test
    @Order(3)
     public void testGetStudentByName()
    {
        //given
        Student Ranjith = Student.builder()
                .name("Ramu")
                .email("ranjith@gmail.com")
                .study("9th")
                .address(null)
                .build();
        Address RanjithAddress = Address.builder().City("warangal").State("telangana").pinCode(578947).build();
        Ranjith.setAddress(RanjithAddress);
        Student savedStudent = studentRepository.save(Ranjith);

        //when
        Student student = studentRepository.getStudentByName("Ramu");

        //then
        Assertions.assertThat(savedStudent.getId()).isNotNull();
        Assertions.assertThat(student.getName()).isEqualTo("Ramu");
    }

    @Test
   @Order(2)
    public void saveStudent() {
        //given
        Student student = Student.builder()
                .name("Ranj")
                .email("ranjith123@gnail.com")
                .study("9th")
                .address(null)
                .build();
        //when
        studentRepository.save(student);

        // then
        Assertions.assertThat(student.getId()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void deleteStudent(){
        //given
        Student student = Student.builder()
                .name("Ranjith")
                .email("ranjith123@gnail.com")
                .study("9th")
                .address(null)
                .build();
        //when
        studentRepository.delete(student);
        //then
        Assertions.assertThat(student.getId()).isEqualTo(0);
    }

    @Test
    public void getStudentTest() {
        //given
        //when
        Student student = studentRepository.findById(1).get();
        //then
        Assertions.assertThat(student.getId()).isEqualTo(1);
    }




}
