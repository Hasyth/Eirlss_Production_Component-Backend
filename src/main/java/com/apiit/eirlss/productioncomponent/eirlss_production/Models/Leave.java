package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class Leave {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    private String leave_Type;
    private Date leave_Date;

    public String getLeave_Type() {
        return leave_Type;
    }

    public void setLeave_Type(String leave_Type) {
        this.leave_Type = leave_Type;
    }

    public Date getLeave_Date() {
        return leave_Date;
    }

    public void setLeave_Date(Date leave_Date) {
        this.leave_Date = leave_Date;
    }
}
