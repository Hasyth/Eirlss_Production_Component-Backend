package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.util.Date;

@Entity
public class BillItem {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    private String billitem_ID;
    private String quantity;

    @ManyToOne
    private BillOfMaterials bom_ID;

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

    public BillOfMaterials getBom_ID() {
        return bom_ID;
    }

    public void setBom_ID(BillOfMaterials bom_ID) {
        this.bom_ID = bom_ID;
    }
}
