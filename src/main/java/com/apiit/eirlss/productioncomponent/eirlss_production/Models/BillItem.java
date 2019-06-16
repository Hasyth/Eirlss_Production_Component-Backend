package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class BillItem {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    @Column(name="billitem_id")
    private String billitem_ID;

    @Column(name="quantity")
    private String quantity;


    @ManyToOne
    @JoinColumn
    private BillOfMaterials billOfMaterials;

    public String getBillitem_ID() {
        return billitem_ID;
    }

    public void setBillitem_ID(String billitem_ID) {
        this.billitem_ID = billitem_ID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public BillOfMaterials getBillOfMaterials() {
        return billOfMaterials;
    }

    public void setBillOfMaterials(BillOfMaterials billOfMaterials) {
        this.billOfMaterials = billOfMaterials;
    }
}
