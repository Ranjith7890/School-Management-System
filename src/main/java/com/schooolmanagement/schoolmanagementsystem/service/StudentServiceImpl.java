package com.schooolmanagement.schoolmanagementsystem.service;



import com.schooolmanagement.schoolmanagementsystem.exception.ResourceNotFoundException;
import com.schooolmanagement.schoolmanagementsystem.model.Student;
import com.schooolmanagement.schoolmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;
@Service
public class StudentServiceImpl implements StudentService {
     @Autowired
     StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {

        return  studentRepository.findAll();
    }

    @Override
    public Student getStudent(int id) {

       studentRepository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Student","id",id));

        return studentRepository.findById(id).get();
    }


    @Override
    public Student addStudent(Student student) {
        if(student == null ){
            throw  new ResourceNotFoundException("Student","Student id",student.getId());

        }

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student studentDetails) {
        Student student = studentRepository.findById(studentDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Student","id",studentDetails.getId()));

        student.setEmail(studentDetails.getEmail());

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        String delete = "successfully deleted";
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student","id",id));

        studentRepository.deleteById(id);
    }

   @Override
    public Student updateStudentWithMap(int id, Map<Object, Object> objectMap) {
       Student student = studentRepository.findById(id).get();
        objectMap.forEach((key,value) -> {
            Field field = ReflectionUtils.findField(Student.class,(String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, student,value);

        });
        return studentRepository.save(student);

    }





}
