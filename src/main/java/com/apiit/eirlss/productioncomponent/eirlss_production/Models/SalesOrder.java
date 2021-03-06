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
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "buisiness_id")
    private String businessId;
    @Column(name = "order_duedate")
    private Date orderDuedate;
    @Column(name = "date")
    private Date date;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "order_type")
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

    public Date getOrderDuedate() {
        return orderDuedate;
    }

    public void setOrderDuedate(Date orderDuedate) {
        this.orderDuedate = orderDuedate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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