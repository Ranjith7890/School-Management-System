package com.schooolmanagement.schoolmanagementsystem.service;

import com.schooolmanagement.schoolmanagementsystem.model.Teacher;

import java.util.List;

public interface TeacherServices {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(int id);
    Teacher addTeacher(Teacher teacher);
}
