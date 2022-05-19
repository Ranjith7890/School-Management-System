package com.schooolmanagement.schoolmanagementsystem.dto;

import com.schooolmanagement.schoolmanagementsystem.model.Address;
import com.schooolmanagement.schoolmanagementsystem.model.Teacher;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Builder
public class StudentDto {
    private String name;
    private String study;
    private Address address;
    private List<Teacher> teachers;




}
