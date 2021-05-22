package com.silvertouch.employeemanagementsystem.controller;

import com.silvertouch.employeemanagementsystem.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sv/ems")
public class EmployeeManagementController {

    private final EmployeeManagementService employeeManagementService;
    @Autowired
    public EmployeeManagementController(EmployeeManagementService employeeManagementService) {
        this.employeeManagementService = employeeManagementService;
    }
}
