package com.silvertouch.employeemanagementsystem.controller;

import com.silvertouch.employeemanagementsystem.model.EmployeeMaster;
import com.silvertouch.employeemanagementsystem.model.QualificationMaster;
import com.silvertouch.employeemanagementsystem.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sv/ems")
public class EmployeeManagementController {

    private final EmployeeManagementService employeeManagementService;
    @Autowired
    public EmployeeManagementController(EmployeeManagementService employeeManagementService) {
        this.employeeManagementService = employeeManagementService;
    }

    @GetMapping("/getEmployeeList")
    public ResponseEntity<Object> getEmployeeList(){
        List<EmployeeMaster> employeeMasterList = employeeManagementService.getEmployeeList();
        return ResponseEntity.status(HttpStatus.OK).body(employeeMasterList);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable(value = "id") long id){
        EmployeeMaster employeeMaster = employeeManagementService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeMaster);
    }

    @GetMapping("/getQualifications")
    public  ResponseEntity<Object> getQualifications(){
        List<QualificationMaster> qualificationMasterList = employeeManagementService.qualificationList();
        return ResponseEntity.status(HttpStatus.OK).body(qualificationMasterList);
    }

    @PostMapping(value = "/addEmployee", consumes = "application/json")
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody EmployeeMaster employeeMaster){
        employeeMaster = employeeManagementService.addEmployee(employeeMaster);
        return ResponseEntity.status(HttpStatus.OK).body(employeeMaster);
    }

    @PutMapping(value = "/updateEmployee/{id}", consumes = "application/json")
    public ResponseEntity<Object> updateEmployee(@PathVariable(value = "id") long id, @Valid @RequestBody EmployeeMaster employeeMaster){
        employeeMaster = employeeManagementService.updateEmployee(employeeMaster, id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeMaster);
    }
}
