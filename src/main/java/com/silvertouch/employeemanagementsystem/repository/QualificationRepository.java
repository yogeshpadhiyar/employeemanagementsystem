package com.silvertouch.employeemanagementsystem.repository;

import com.silvertouch.employeemanagementsystem.model.QualificationMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<QualificationMaster, Long> {
}
