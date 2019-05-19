package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class WorkSchedule {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    private String schedule_ID;
    private Time start_Time;
    private Time end_Time;
    private Date date;

    public String getSchedule_ID() {
        return schedule_ID;
    }

    public void setSchedule_ID(String schedule_ID) {
        this.schedule_ID = schedule_ID;
    }

    public Time getStart_Time() {
        return start_Time;
    }

    public void setStart_Time(Time start_Time) {
        this.start_Time = start_Time;
    }

    public Time getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(Time end_Time) {
        this.end_Time = end_Time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
