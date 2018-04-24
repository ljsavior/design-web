package com.eternal.design.entity;

import java.util.Date;

public class CoachPatientRelationship {
    private Integer id;

    private Integer coachUserId;

    private Integer patientUserId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoachUserId() {
        return coachUserId;
    }

    public void setCoachUserId(Integer coachUserId) {
        this.coachUserId = coachUserId;
    }

    public Integer getPatientUserId() {
        return patientUserId;
    }

    public void setPatientUserId(Integer patientUserId) {
        this.patientUserId = patientUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}