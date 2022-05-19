package com.schooolmanagement.schoolmanagementsystem.service;




import com.schooolmanagement.schoolmanagementsystem.model.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudent(int id);
    Student addStudent(Student student);
    Student updateStudent(Student studentDetails);
    void deleteStudent(int id);

    Student updateStudentWithMap(int id, Map<Object, Object> objectObjectMap);
}
