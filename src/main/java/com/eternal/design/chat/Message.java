package com.eternal.design.chat;

import com.alibaba.fastjson.JSON;

public class Message {
    private String from;
    private String to;
    private String msg;

    public Message() {
    }

    public Message(String from, String to, String msg) {
        this.from = from;
        this.to = to;
        this.msg = msg;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static Message fromJSONString(String jsonString) {
        return JSON.parseObject(jsonString, Message.class);
    }
}
