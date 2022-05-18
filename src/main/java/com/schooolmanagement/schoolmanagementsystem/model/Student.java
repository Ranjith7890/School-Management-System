package com.schooolmanagement.schoolmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="Student_Details")
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
 @Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Student name should not be null")
    @Column(name="name")
    private String name;
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "study field required it cannot be null")
    private String study;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_id")
    private  Address address;


   // @ManyToOne(cascade = CascadeType.ALL)
    @OneToMany( cascade = CascadeType.ALL)
     private List<Teacher> teacher;



}
