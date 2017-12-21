package com.eternal.design.entity;

import java.util.Date;

public class Command {
    private Integer id;

    private Byte commandFunction;

    private String commandDescription;

    private String returnDataDescription;

    private Date createTime;

    private Date lastModTime;

    private String modUserId;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getCommandFunction() {
        return commandFunction;
    }

    public void setCommandFunction(Byte commandFunction) {
        this.commandFunction = commandFunction;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public void setCommandDescription(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    public String getReturnDataDescription() {
        return returnDataDescription;
    }

    public void setReturnDataDescription(String returnDataDescription) {
        this.returnDataDescription = returnDataDescription;
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

    public String getModUserId() {
        return modUserId;
    }

    public void setModUserId(String modUserId) {
        this.modUserId = modUserId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}