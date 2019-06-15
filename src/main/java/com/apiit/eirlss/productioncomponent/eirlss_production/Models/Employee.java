package com.apiit.eirlss.productioncomponent.eirlss_production.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    private String employee_ID;

    private String name;
    private String address;
    private Integer contact_Number;
    private String email;
    private String username;
    private String password;

    @OneToMany(mappedBy = "employee_ID")
    @JsonIgnoreProperties("employee_ID")
    private Set<WorkSchedule> workSchedules;

    @OneToMany(mappedBy = "employee_ID")
    @JsonIgnoreProperties("employee_ID")
    private Set<Inspection> inspections;


    public String getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(String employee_ID) {
        this.employee_ID = employee_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContact_Number() {
        return contact_Number;
    }

    public void setContact_Number(Integer contact_Number) {
        this.contact_Number = contact_Number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<WorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    public void setWorkSchedules(Set<WorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
    }

    public Set<Inspection> getInspections() {
        return inspections;
    }

    public void setInspections(Set<Inspection> inspections) {
        this.inspections = inspections;
    }
}
