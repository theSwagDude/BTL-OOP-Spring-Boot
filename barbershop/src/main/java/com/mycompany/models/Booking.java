package com.mycompany.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Date;
import lombok.Data;
@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user_id;
    private int service_id;
    private int employee_id;
    private Time set_hour;
    private Date set_date;
    private String note;
}

