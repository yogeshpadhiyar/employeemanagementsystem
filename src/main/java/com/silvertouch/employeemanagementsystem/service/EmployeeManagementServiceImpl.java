package com.silvertouch.employeemanagementsystem.service;

import com.silvertouch.employeemanagementsystem.constant.AppConstant;
import com.silvertouch.employeemanagementsystem.exception.CustomException;
import com.silvertouch.employeemanagementsystem.model.EmployeeMaster;
import com.silvertouch.employeemanagementsystem.model.QualificationMaster;
import com.silvertouch.employeemanagementsystem.repository.EmployeeManagementRepository;
import com.silvertouch.employeemanagementsystem.repository.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService{

    private final EmployeeManagementRepository employeeManagementRepository;
    private final QualificationRepository qualificationRepository;
    @Autowired
    public EmployeeManagementServiceImpl(EmployeeManagementRepository employeeManagementRepository, QualificationRepository qualificationRepository) {
        this.employeeManagementRepository = employeeManagementRepository;
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public List<EmployeeMaster> getEmployeeList() {
        List<EmployeeMaster> employeeMasterList = employeeManagementRepository.findAll();
        if(!employeeMasterList.isEmpty()){
            return employeeMasterList;
        }else {
            throw new CustomException(HttpStatus.NOT_FOUND, AppConstant.NOT_ANY_USERS);
        }
    }

    @Override
    public EmployeeMaster getEmployee(long id) {
        return employeeManagementRepository.findById(id).orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND, AppConstant.USER_NOT_FOUND));
    }

    @Override
    public EmployeeMaster addEmployee(EmployeeMaster employeeMaster) {
        if(qualificationList().stream().anyMatch(q-> q.getId()==employeeMaster.getQualificationMaster().getId())) {
            return employeeManagementRepository.save(employeeMaster);
        }else {
            throw new CustomException(HttpStatus.NOT_FOUND,AppConstant.QUALIFICATION_NOT_FOUND);
        }
    }

    @Override
    public EmployeeMaster updateEmployee(EmployeeMaster employeeMaster, long id) {
        if(employeeManagementRepository.findById(id).isPresent()) {
            employeeMaster.setId(id);
            return employeeManagementRepository.save(employeeMaster);
        }else {
            throw new CustomException(HttpStatus.NOT_FOUND,AppConstant.USER_NOT_FOUND);
        }
    }

    @Override
    public List<QualificationMaster> qualificationList() {
        return qualificationRepository.findAll();
    }
}
