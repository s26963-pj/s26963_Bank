package com.example.s26963_bank.exceptions;


public class ValidationException extends RuntimeException{
    public ValidationException(String message){
        super(message);
    }
}
