package com.silvertouch.employeemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblpersonalMaster")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonMaster {

    @OneToOne
    private EmployeeMaster employeeMaster;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;

}
