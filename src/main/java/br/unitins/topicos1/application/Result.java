package br.unitins.topicos1.application;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;

public class Result {

    private String message;
    private boolean success;

    public Result(String message){
        this.message = message;
        this.success = true;
    }

    public Result(String message, boolean success){
        this.message = message;
        this.success = success;
    }

    public String getMessage(){
        return message;
    }

    public boolean isSuccess(){
        return success;
    }

    public Result(Set<? extends ConstraintViolation<?>> violations){
        this.success = false;
        this.message = violations.stream()
            .map(cv -> cv.getMessage())
            .collect(Collectors.joining(", "));
    }
}