package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Entity
public class BillOfMaterials {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    @Column(name="bom_id")
    private String bom_ID;

    @Column(name="bom_status")
    private String bomStatus;
    @Column(name="order_date")
    private Date orderDate;

    @OneToOne
    private OrderItem orderItems;

    @OneToMany(mappedBy = "billOfMaterials")
    @JsonIgnoreProperties("billOfMaterials")
    private Set<BillItem> billItems;

    public String getBom_ID() {
        return bom_ID;
    }

    public void setBom_ID(String bom_ID) {
        this.bom_ID = bom_ID;
    }

    public Date getOrder_Date() {
        return orderDate;
    }

    public void setOrder_Date(Date order_Date) {
        this.orderDate = order_Date;
    }

    public Set<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(Set<BillItem> billItems) {
        this.billItems = billItems;
    }

    public String getBomStatus() {
        return bomStatus;
    }

    public void setBomStatus(String bomStatus) {
        this.bomStatus = bomStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderItem getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem orderItems) {
        this.orderItems = orderItems;
    }
}
