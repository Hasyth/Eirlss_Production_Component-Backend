package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RejectionNotice {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    @Column(name = "rejection_notice_id")
    private String rejection_notice_ID;

    @Column(name = "notice_date")
    private Date notice_Date;
    @Column(name = "rejected_reason")
    private String rejected_Reason;
    @Column(name = "remedy_action")
    private String remedy_Action;

    @ManyToOne
    @JoinColumn
    private OrderItem orderItems;


    public String getRejection_notice_ID() {
        return rejection_notice_ID;
    }

    public void setRejection_notice_ID(String rejection_notice_ID) {
        this.rejection_notice_ID = rejection_notice_ID;
    }

    public Date getNotice_Date() {
        return notice_Date;
    }

    public void setNotice_Date(Date notice_Date) {
        this.notice_Date = notice_Date;
    }

    public String getRejected_Reason() {
        return rejected_Reason;
    }

    public void setRejected_Reason(String rejected_Reason) {
        this.rejected_Reason = rejected_Reason;
    }

    public String getRemedy_Action() {
        return remedy_Action;
    }

    public void setRemedy_Action(String remedy_Action) {
        this.remedy_Action = remedy_Action;
    }

    public OrderItem getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem orderItems) {
        this.orderItems = orderItems;
    }
}
