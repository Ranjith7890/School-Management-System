package com.schooolmanagement.schoolmanagementsystem.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="Teacher_Details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int t_id;
    @NotNull(message = "name should not be null")
    private String name;
    @Email(message = "Invalid Email")
    private String email;
 //   @Pattern(regexp = "^\\d{10}$", message = "Invalid Phone number entered")
    private Long phone_number;

    //@OneToMany(cascade = CascadeType.ALL)
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

}
