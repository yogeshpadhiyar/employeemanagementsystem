package com.silvertouch.employeemanagementsystem.repository;

import com.silvertouch.employeemanagementsystem.model.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeManagementRepository extends JpaRepository<EmployeeMaster, Long> {
}
