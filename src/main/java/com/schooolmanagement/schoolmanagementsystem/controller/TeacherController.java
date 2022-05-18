package com.schooolmanagement.schoolmanagementsystem.controller;

import com.schooolmanagement.schoolmanagementsystem.model.Student;
import com.schooolmanagement.schoolmanagementsystem.model.Teacher;
import com.schooolmanagement.schoolmanagementsystem.service.TeacherServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherServiceimpl;

    @Operation(summary = "get Teacher details",description ="get a list of Teacher details", tags= "get")
    @ApiResponse(responseCode = "200", description = "Found the teacher", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))})
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return teacherServiceimpl.getAllTeachers();
    }


    @Operation(summary = "get teacher details",description ="get a list of particular Teacher details", tags= "get")
    @ApiResponse(responseCode = "200", description = "Found the teacher", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))})
    @GetMapping("/teacher/{id}")
    public Teacher getTeacherById(@PathVariable("id") int id){

        return teacherServiceimpl.getTeacherById(id);
    }


    @Operation(summary = "insert teacher details",description ="Inserting  particular teacher details", tags= "post")
    @ApiResponse(responseCode = "200", description = "Inserted the teacher details", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Teacher.class))})


    @PostMapping("/adding")
    public Teacher addTeacher(@RequestBody Teacher teacher){

        return teacherServiceimpl.addTeacher(teacher);
    }
}
