package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductDesignItem {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    @Column(name = "product_design_item_id")
    private String productDesignItem_ID;

    @Column(name = "quantity")
    private Integer quantity;

    public String getProductDesignItem_ID() {
        return productDesignItem_ID;
    }

    public void setProductDesignItem_ID(String productDesignItem_ID) {
        this.productDesignItem_ID = productDesignItem_ID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
