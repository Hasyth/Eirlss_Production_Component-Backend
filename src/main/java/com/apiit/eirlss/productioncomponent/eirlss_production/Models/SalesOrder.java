package com.apiit.eirlss.productioncomponent.eirlss_production.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class SalesOrder {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    @Column(name="order_id")
    private String orderId;

    @Column(name="buisness_id")
    private String businessId;
    @Column(name="order_duedate")
    private Date order_Duedate;
    @Column(name="date")
    private Date date;
    @Column(name="end_date")
    private Date end_Date;
    @Column(name="order_status")
    private String orderStatus;
    @Column(name="order_type")
    private String orderType;


    @OneToMany(mappedBy = "salesOrders")
    @JsonIgnoreProperties("salesOrders")
    private Set<OrderItem> orderItems;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Date getOrder_Duedate() {
        return order_Duedate;
    }

    public void setOrder_Duedate(Date order_Duedate) {
        this.order_Duedate = order_Duedate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}