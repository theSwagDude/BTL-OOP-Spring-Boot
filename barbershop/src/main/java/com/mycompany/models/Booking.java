package com.mycompany.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
//import java.sql.Time;
//import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Entity
@Table(name = "booking")
@Data
public class Booking implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String service;
    private String employee;
    private LocalTime set_hour;
    private LocalDate set_date;
    private String note;
    private String phone_number;
    private String name;
    private long cost;
//    
//    private int id;
//    private int user_id;
//    
//    private int service_id;
//    private int employee_id;
//    
//    private Time set_hour;
//    private Date set_date;
//    private String note;
}
