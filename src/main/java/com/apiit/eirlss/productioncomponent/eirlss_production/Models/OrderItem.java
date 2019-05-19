package com.apiit.eirlss.productioncomponent.eirlss_production.Models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    private String orderitem_ID;
    private Integer quantity;

    public String getOrderitem_ID() {
        return orderitem_ID;
    }

    public void setOrderitem_ID(String orderitem_ID) {
        this.orderitem_ID = orderitem_ID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}