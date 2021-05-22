package com.silvertouch.employeemanagementsystem.service;

import com.silvertouch.employeemanagementsystem.model.EmployeeMaster;
import com.silvertouch.employeemanagementsystem.model.QualificationMaster;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeManagementService {

    List<EmployeeMaster> getEmployeeList();

    EmployeeMaster getEmployee(long id);

    EmployeeMaster addEmployee(EmployeeMaster employeeMaster);

    EmployeeMaster updateEmployee(EmployeeMaster employeeMaster, long id);

    //Also create separate service for qualification table. But as of now i have only one service so doesn't create it.
    List<QualificationMaster> qualificationList();
}
