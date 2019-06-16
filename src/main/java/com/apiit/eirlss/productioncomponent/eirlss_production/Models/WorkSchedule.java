package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class WorkSchedule {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    @Column(name="schedule_id")
    private String schedule_ID;
    @Column(name="start_time")
    private Time start_Time;
    @Column(name="end_time")
    private Time end_Time;
    @Column(name="date")
    private Date date;

    @ManyToOne
    @JoinColumn
    private Employee employees;

    @ManyToOne
    @JoinColumn
    private CapacityPlan capacityplans;

    @ManyToOne
    @JoinColumn
    private OrderItem orderItems;

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

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }

    public CapacityPlan getCapacityPlans() {
        return capacityplans;
    }

    public void setCapacityPlans(CapacityPlan capacityPlans) {
        this.capacityplans = capacityPlans;
    }

    public OrderItem getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem orderItems) {
        this.orderItems = orderItems;
    }


}


