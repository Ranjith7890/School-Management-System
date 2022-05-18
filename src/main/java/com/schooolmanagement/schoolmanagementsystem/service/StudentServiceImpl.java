package com.schooolmanagement.schoolmanagementsystem.service;



import com.schooolmanagement.schoolmanagementsystem.exception.ResourceNotFoundException;
import com.schooolmanagement.schoolmanagementsystem.model.Student;
import com.schooolmanagement.schoolmanagementsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
