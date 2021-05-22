package com.silvertouch.employeemanagementsystem.service;

import com.silvertouch.employeemanagementsystem.model.EmployeeMaster;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeManagementService {

    List<EmployeeMaster> getEmployeeList();

    EmployeeMaster getEmployee(long id);

    EmployeeMaster addEmployee(EmployeeMaster employeeMaster);

    EmployeeMaster updateEmployee(EmployeeMaster employeeMaster);


}
