package com.schooolmanagement.schoolmanagementsystem.mapper;

import com.schooolmanagement.schoolmanagementsystem.dto.StudentDto;
import com.schooolmanagement.schoolmanagementsystem.model.Student;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface StudentMapper {

    StudentDto toStudentDto(Student student);

    Student toStudent(StudentDto studentDto);

    List<StudentDto> ToStudentDtoS (List<Student> students);

    List<Student> ToStudentS (List<StudentDto> studentDtoS);
}
