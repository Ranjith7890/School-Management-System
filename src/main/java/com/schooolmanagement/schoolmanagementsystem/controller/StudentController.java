package com.schooolmanagement.schoolmanagementsystem.controller;



import java.util.Optional;
import com.schooolmanagement.schoolmanagementsystem.dto.StudentDto;
import com.schooolmanagement.schoolmanagementsystem.exception.ResourceNotFoundException;
import com.schooolmanagement.schoolmanagementsystem.mapper.StudentMapper;
import com.schooolmanagement.schoolmanagementsystem.mapper.StudentMappers;
import com.schooolmanagement.schoolmanagementsystem.model.Student;
import com.schooolmanagement.schoolmanagementsystem.service.StudentServiceImpl;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class StudentController {
      @Autowired
      StudentServiceImpl studentServiceImpl;


   // private StudentMapper studentMapper;


    @Operation(summary = "get Student details", description = "get a list of Student details", tags = "get")
    @ApiResponse(responseCode = "200", description = "Found the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @GetMapping("/students")
    List<Student> getAllStudents() {

        return studentServiceImpl.getAllStudents();
    }


    @Operation(summary = "get Student details", description = "get a list of particular Student details", tags = "get")
    @ApiResponse(responseCode = "200", description = "Found the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @GetMapping("/students/{id}")
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
  /**  @Operation(summary = "update the  Student details", description = "updating particular Student details", tags = "put")
    @ApiResponse(responseCode = "200", description = "updated the Student details", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @PatchMapping("/update")
    public String updateStudents(@Valid  @RequestBody Student studentDetails) {
        studentServiceImpl.updateStudent(studentDetails);
        return "successfully updated";
    }  */

    @Operation(summary = "Delete Student", description = "Delete a  particular Student details", tags = "delete")
    @ApiResponse(responseCode = "200", description = "deleted the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id)  {
        String delete = "successfully deleted";
         studentServiceImpl.deleteStudent(id);
        return delete;
    }
    @GetMapping("studentDTO/{id}")
    public StudentDto findUserById(@PathVariable("id") int id){
        Student studentData = studentServiceImpl.getStudent(id);
        return StudentMappers.toStudentDto(studentData);
  }
}

  /**  @GetMapping("/stud")

    public ResponseEntity<List<StudentDto>> getAllStudent() {
        List<StudentDto> studentDtoList = studentMapper.ToStudentDtoS(studentServiceImpl.getAllStudents());


        return ResponseEntity.ok(studentDtoList);
    }



    @GetMapping("/stu/{id}")

    public ResponseEntity<StudentDto> findById(@PathVariable int id)
    {

    Student student = studentServiceImpl.getStudent(id);
        StudentDto studentDto = studentMapper.toStudentDto(student);
        return ResponseEntity.ok(studentDto);
    }

    @PostMapping("/insertValues")
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto)
    {
        System.out.println(studentDto);
        Student student = studentMapper.toStudent(studentDto);
        System.out.println("StudentMapper = " + studentMapper);
        System.out.println(student);
        System.out.println("studentServiceImpl= " + studentServiceImpl);
        studentServiceImpl.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);
    }


}  */
