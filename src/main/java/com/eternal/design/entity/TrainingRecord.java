package com.eternal.design.entity;

import java.util.Date;

public class TrainingRecord {
    private Integer id;

    private Integer userId;

    private String trainingName;

    private Short trainingType;

    private String timesUsed;

    private String result;

    private Integer score;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public Short getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(Short trainingType) {
        this.trainingType = trainingType;
    }

    public String getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(String timesUsed) {
        this.timesUsed = timesUsed;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}