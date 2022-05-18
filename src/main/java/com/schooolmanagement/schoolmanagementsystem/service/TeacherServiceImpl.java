package com.schooolmanagement.schoolmanagementsystem.service;

import com.schooolmanagement.schoolmanagementsystem.model.Teacher;
import com.schooolmanagement.schoolmanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements  TeacherServices{

    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherRepository.getById(id);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
