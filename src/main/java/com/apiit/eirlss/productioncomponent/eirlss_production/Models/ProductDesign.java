package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductDesign {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    private String design_ID;
    private Integer required_Workhours;

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
