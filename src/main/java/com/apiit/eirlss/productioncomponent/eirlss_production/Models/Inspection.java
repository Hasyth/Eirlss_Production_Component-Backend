package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;


@Entity
public class Inspection {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    private String inspection_ID;
    private Timestamp date_Time;

    public String getInspection_ID() {
        return inspection_ID;
    }

    public void setInspection_ID(String inspection_ID) {
        this.inspection_ID = inspection_ID;
    }

    public Timestamp getDate_Time() {
        return date_Time;
    }

    public void setDate_Time(Timestamp date_Time) {
        this.date_Time = date_Time;
    }
}
