package com.silvertouch.employeemanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tblQualificationMaster")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualificationMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String qualification;
}
