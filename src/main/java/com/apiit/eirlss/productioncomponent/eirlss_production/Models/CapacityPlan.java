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
public class CapacityPlan {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    private String plan_ID;
    private Date start_Date;
    private Date end_Date;

    @OneToMany(mappedBy = "plan_ID")
    @JsonIgnoreProperties("plan_ID")
    private Set<WorkSchedule> workSchedules;

    public String getPlan_ID() {
        return plan_ID;
    }

    public void setPlan_ID(String plan_ID) {
        this.plan_ID = plan_ID;
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

    public Set<WorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    public void setWorkSchedules(Set<WorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
    }
}
