package com.schooolmanagement.schoolmanagementsystem.service;




import com.schooolmanagement.schoolmanagementsystem.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudent(int id);
    Student addStudent(Student student);
    Student updateStudent(Student studentDetails);
    void deleteStudent(int id);

  //  List<Student>  getByStudy(String study);
    public Page<Student> getStudentWithPagination(int pageNumber ,int pageSize, String field);

    Student updateStudentWithMap(int id, Map<Object, Object> objectObjectMap);
}
