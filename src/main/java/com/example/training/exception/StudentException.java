package com.example.training.exception;

public class StudentException extends BaseException{
    public StudentException(String code){
        super(code);
    }

    public static StudentException StudentNotFound(int id){
        return new StudentException("student id " + id + " doesn't exist");
    }

    public static StudentException NameFormatException(String code){
        return new StudentException(code + "format must be a-z or A-Z.");
    }

    public static StudentException GradeFormatException(String code){
        return new StudentException("grade format must be A - F.");
    }

    public static StudentException GenderFormatException(String code){
        return new StudentException("gender format must be M or F.");
    }

    public static StudentException DataNullException(String code){
        return new StudentException(code + " is null or empty.");
    }
}
