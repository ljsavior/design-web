package com.eternal.design.entity;

public class TrainingRecordWithBLOBs extends TrainingRecord {
    private String timesUsed;

    private String result;

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
}