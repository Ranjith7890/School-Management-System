package com.schooolmanagement.schoolmanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
@Data
@Builder
public class TeacherDTO {

    private String name;

    private String email;

    private Long phone_number;

}
