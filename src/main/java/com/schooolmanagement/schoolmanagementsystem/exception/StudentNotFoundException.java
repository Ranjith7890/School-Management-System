package com.schooolmanagement.schoolmanagementsystem.exception;

public class StudentNotFoundException extends  RuntimeException{
    private final String message;
    private final String field;

    public StudentNotFoundException(String message, String field) {
        super(String.format("%s not found with %s : '%s'", field));
        this.message = message;
        this.field = field;
    }


}
