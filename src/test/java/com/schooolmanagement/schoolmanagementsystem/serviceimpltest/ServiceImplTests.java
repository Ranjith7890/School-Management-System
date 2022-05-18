package com.schooolmanagement.schoolmanagementsystem.serviceimpltest;

import com.schooolmanagement.schoolmanagementsystem.model.Student;
import com.schooolmanagement.schoolmanagementsystem.repository.StudentRepository;
import com.schooolmanagement.schoolmanagementsystem.service.StudentServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceImplTests {

    @Autowired
    StudentServiceImpl studentServiceImpl;



    @Test
    public void  saveStudent(){
        //given
        Student student = Student.builder()
                .name("Ranjith")
                .email("ranjith123@gnail.com")
                .study("9th")
                .address(null)
                .build();
        //when
        studentServiceImpl.addStudent(student);

        //then
        Assertions.assertThat(student.getId()).isGreaterThan(0);
    }

    @Test
    public void getStudentById(){

        //given
        // when
      Student student =  studentServiceImpl.getStudent(1);

      //then
        Assertions.assertThat(student.getId()).isEqualTo(1);

    }

    @Test
    public void updateStudent(){
        //given
        Student student =  studentServiceImpl.getStudent(1);
        //when
        student.setEmail("ranjith12345@gmail.com");
        //then
        Assertions.assertThat(student.getEmail()).isEqualTo("ranjith12345@gmail.com");
    }

}
