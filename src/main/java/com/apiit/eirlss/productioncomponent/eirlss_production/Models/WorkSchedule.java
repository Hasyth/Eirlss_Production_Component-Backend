package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    private Employee employee_ID;

    @ManyToOne
    private CapacityPlan plan_ID;

    @ManyToOne
    private OrderItem orderItem_ID;

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

    public Employee getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(Employee employee_ID) {
        this.employee_ID = employee_ID;
    }

    public CapacityPlan getPlan_ID() {
        return plan_ID;
    }

    public void setPlan_ID(CapacityPlan plan_ID) {
        this.plan_ID = plan_ID;
    }

    public OrderItem getOrderItem_ID() {
        return orderItem_ID;
    }

    public void setOrderItem_ID(OrderItem orderItem_ID) {
        this.orderItem_ID = orderItem_ID;
    }
}


