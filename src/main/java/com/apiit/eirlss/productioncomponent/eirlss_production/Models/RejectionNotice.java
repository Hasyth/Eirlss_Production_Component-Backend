package com.apiit.eirlss.productioncomponent.eirlss_production.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class RejectionNotice {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy ="uuid")
    private String rejection_notice_ID;
    private Date notice_Date;
    private String rejected_Reason;
    private String remedy_Action;




    public String getRejection_notice_ID() {
        return rejection_notice_ID;
    }

    public void setRejection_notice_ID(String rejection_notice_ID) {
        this.rejection_notice_ID = rejection_notice_ID;
    }

    public Date getNotice_Date() {
        return notice_Date;
    }

    public void setNotice_Date(Date notice_Date) {
        this.notice_Date = notice_Date;
    }

    public String getRejected_Reason() {
        return rejected_Reason;
    }

    public void setRejected_Reason(String rejected_Reason) {
        this.rejected_Reason = rejected_Reason;
    }

    public String getRemedy_Action() {
        return remedy_Action;
    }

    public void setRemedy_Action(String remedy_Action) {
        this.remedy_Action = remedy_Action;
    }
}
