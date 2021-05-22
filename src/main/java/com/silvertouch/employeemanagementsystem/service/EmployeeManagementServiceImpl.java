package com.silvertouch.employeemanagementsystem.service;

import com.silvertouch.employeemanagementsystem.model.EmployeeMaster;
import com.silvertouch.employeemanagementsystem.repository.EmployeeManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService{

    private final EmployeeManagementRepository employeeManagementRepository;
    @Autowired
    public EmployeeManagementServiceImpl(EmployeeManagementRepository employeeManagementRepository) {
        this.employeeManagementRepository = employeeManagementRepository;
    }

    @Override
    public List<EmployeeMaster> getEmployeeList() {
        return null;
    }

    @Override
    public EmployeeMaster getEmployee(long id) {
        return null;
    }

    @Override
    public EmployeeMaster addEmployee(EmployeeMaster employeeMaster) {
        return null;
    }

    @Override
    public EmployeeMaster updateEmployee(EmployeeMaster employeeMaster) {
        return null;
    }
}
