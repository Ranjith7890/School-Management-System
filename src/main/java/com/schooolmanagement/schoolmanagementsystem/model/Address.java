package com.schooolmanagement.schoolmanagementsystem.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Address_Details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int address_id;
    @NotNull
    private int pinCode;
    @NotNull
    private String City;
    @NotNull
    private String State;






}
