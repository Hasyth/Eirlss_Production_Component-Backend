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
    private String bom_ID;
    private Date order_Date;

    @OneToMany(mappedBy = "bom_ID")
    @JsonIgnoreProperties("bom_ID")
    private Set<BillItem> billItems;

    public String getBom_ID() {
        return bom_ID;
    }

    public void setBom_ID(String bom_ID) {
        this.bom_ID = bom_ID;
    }

    public Date getOrder_Date() {
        return order_Date;
    }

    public void setOrder_Date(Date order_Date) {
        this.order_Date = order_Date;
    }

    public Set<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(Set<BillItem> billItems) {
        this.billItems = billItems;
    }
}
