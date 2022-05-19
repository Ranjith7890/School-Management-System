package com.schooolmanagement.schoolmanagementsystem.controller;



import com.schooolmanagement.schoolmanagementsystem.dto.StudentDto;
import com.schooolmanagement.schoolmanagementsystem.exception.ResourceNotFoundException;
import com.schooolmanagement.schoolmanagementsystem.mapper.StudentMappers;
import com.schooolmanagement.schoolmanagementsystem.model.Student;
import com.schooolmanagement.schoolmanagementsystem.service.StudentServiceImpl;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
@Slf4j
public class StudentController {
      @Autowired
      StudentServiceImpl studentServiceImpl;


     StudentMappers studentMappers;


    @Operation(summary = "get Student details", description = "get a list of Student details", tags = "get")
    @ApiResponse(responseCode = "200", description = "Found the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @GetMapping("/students")
    List<Student> getAllStudents() {

        return studentServiceImpl.getAllStudents();
    }


    @Operation(summary = "get Student details", description = "get a list of particular Student details", tags = "get")
    @ApiResponse(responseCode = "200", description = "Found the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @GetMapping("/student/{id}")
    public Student getStudentById(@Valid @PathVariable("id") int id) throws ResourceNotFoundException {
        Student student = studentServiceImpl.getStudent(id);
        if(student == null){
            throw new ResourceNotFoundException("Student","id",id);
        }
      return studentServiceImpl.getStudent(id);
    }


    @Operation(summary = "insert Student details", description = "Inserting  particular Student details", tags = "post")
    @ApiResponse(responseCode = "200", description = "Inserted the Student details", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @PostMapping("/insert")
    public String addStudent(@RequestBody Student student) {
        System.out.println(student.toString());
      Student student1 = studentServiceImpl.addStudent(student);
      if(student1==null){
          throw  new ResourceNotFoundException("Student ","id",addStudent(student1));
      }
        return "Successfully Inserted";

    }

    @Operation(summary = "update the  Student details", description = "updating particular Student details", tags = "put")
    @ApiResponse(responseCode = "200", description = "updated the Student details", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @PutMapping("/update")
    public String updateStudent( @Valid @RequestBody Student studentDetails) {
        studentServiceImpl.updateStudent(studentDetails);
        return "successfully updated";
    }


    @Operation(summary = "Delete Student", description = "Delete a  particular Student details", tags = "delete")
    @ApiResponse(responseCode = "200", description = "deleted the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id)  {
        String delete = "successfully deleted";
         studentServiceImpl.deleteStudent(id);
        return delete;
    }

 @PatchMapping("/update/{id}")
    public Student updateStudentWithMap(@PathVariable("id") int id, @RequestBody Map<Object,Object> objectMap){
        return  studentServiceImpl.updateStudentWithMap(id,objectMap);
  }

    @GetMapping("/{id}")
    public StudentDto findUserById(@PathVariable("id") int id){
        Student studentData = studentServiceImpl.getStudent(id);
        return StudentMappers.toStudentDto(studentData);
    }

    @GetMapping("/allStudents")

    public List<StudentDto> getAllStudentDetails() {

        List<Student> allStudents = studentServiceImpl.getAllStudents();

        return StudentMappers.StudentDTOs(allStudents);
    }
}

