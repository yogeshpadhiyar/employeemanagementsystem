package com.silvertouch.employeemanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "tblEmployeeMaster")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonFormat(pattern = "yyyy-MM-dd",lenient = OptBoolean.FALSE)
    @NotNull
    private Date joiningDate;
    @NotNull
    private int salary;
    private String isFresherEmployee;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonMaster personMaster;

    @ManyToOne
    private QualificationMaster qualificationMaster;
}
