package com.eternal.design.entity;

import java.util.Date;

public class Training {
    private Integer id;

    private String name;

    private Date createTime;

    private Date lastModTime;

    private String postures;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(Date lastModTime) {
        this.lastModTime = lastModTime;
    }

    public String getPostures() {
        return postures;
    }

    public void setPostures(String postures) {
        this.postures = postures;
    }
}