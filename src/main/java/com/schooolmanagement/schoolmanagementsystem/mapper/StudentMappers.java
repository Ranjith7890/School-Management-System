package com.schooolmanagement.schoolmanagementsystem.mapper;

import com.schooolmanagement.schoolmanagementsystem.dto.StudentDto;
import com.schooolmanagement.schoolmanagementsystem.model.Address;
import com.schooolmanagement.schoolmanagementsystem.model.Student;
import com.schooolmanagement.schoolmanagementsystem.model.Teacher;

import java.util.*;
import java.util.stream.Collectors;

public class StudentMappers {

  public static StudentDto toStudentDto(Student student){
       if(student == null){
           return null;
       }
        return StudentDto.builder()
                .name(student.getName())
                .study(student.getStudy())
                .address(student.getAddress())
                .teachers(student.getTeacher())
                .build();
    }

 public static   Student toStudent(StudentDto studentDto){
      if(studentDto==null){
          return null;
      }
      return Student.builder()
              .name(studentDto.getName())
              .study(studentDto.getStudy())
              .address(studentDto.getAddress())
              .teacher(studentDto.getTeachers())
              .build();
 }

 public static List<Student> ToStudentDtoS (List<StudentDto> studentDtoList){
      return  studentDtoList.stream().map(a -> toStudent(a)).collect(Collectors.toList());
 }

    public static List<StudentDto> StudentDTOs(List<Student> students){
       return students.stream().map(a -> toStudentDto(a)).collect(Collectors.toList());
    }
}
