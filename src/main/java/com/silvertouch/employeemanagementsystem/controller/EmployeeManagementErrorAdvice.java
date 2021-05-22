package com.silvertouch.employeemanagementsystem.controller;

import com.silvertouch.employeemanagementsystem.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeManagementErrorAdvice {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> handleCustomException(CustomException e){
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
}
