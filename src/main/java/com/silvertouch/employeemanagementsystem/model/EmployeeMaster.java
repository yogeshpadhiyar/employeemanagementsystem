package com.silvertouch.employeemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblEmployeeMaster")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date joiningDate;
    private double salary;
    private String isFresherEmployee;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonMaster personMaster;

    @OneToOne(cascade = CascadeType.ALL)
    private QualificationMaster qualificationMaster;
}
