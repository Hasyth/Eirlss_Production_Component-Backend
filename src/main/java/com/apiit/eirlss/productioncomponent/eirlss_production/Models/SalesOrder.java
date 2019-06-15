package com.apiit.eirlss.productioncomponent.eirlss_production.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
public class SalesOrder {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    private String order_ID;
    private Date order_Duedate;
    private Date start_Date;
    private Date end_Date;

    @OneToMany(mappedBy = "salesOrder_ID")
    @JsonIgnoreProperties("salesOrder_ID")
    private Set<OrderItem> orderItems;

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID;
    }

    public Date getOrder_Duedate() {
        return order_Duedate;
    }

    public void setOrder_Duedate(Date order_Duedate) {
        this.order_Duedate = order_Duedate;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }
}