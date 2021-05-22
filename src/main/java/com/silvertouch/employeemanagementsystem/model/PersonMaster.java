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
@Table(name = "tblpersonalMaster")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date birthDate;
    private String gender;

}
