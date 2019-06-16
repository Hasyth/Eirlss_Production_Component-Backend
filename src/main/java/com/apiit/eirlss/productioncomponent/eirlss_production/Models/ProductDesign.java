package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProductDesign {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    @Column(name = "design_id")
    private String design_ID;

    @Column(name = "required_workhours")
    private Integer required_Workhours;

    @OneToOne
    private Product products;

    public Product getProduct() {
        return products;
    }

    public void setProduct(Product product) {
        this.products = product;
    }

    public String getDesign_ID() {
        return design_ID;
    }

    public void setDesign_ID(String design_ID) {
        this.design_ID = design_ID;
    }

    public Integer getRequired_Workhours() {
        return required_Workhours;
    }

    public void setRequired_Workhours(Integer required_Workhours) {
        this.required_Workhours = required_Workhours;
    }
}
