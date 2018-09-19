package com.codecool.kinder.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Date;

public class Message {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender")
    private Integer sender;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiver")
    private Integer receiver;
    private String message;
    private long timestamp = new Date().getTime();

    public Message(){}


    // Getters


    public Integer getSender() {
        return sender;
    }

    public Integer getReciever() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    //Setters

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public void setReciever(Integer receiver) {
        this.receiver = receiver;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
