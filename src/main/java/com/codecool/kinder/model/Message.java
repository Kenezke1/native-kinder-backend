package com.codecool.kinder.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "messages")
public class Message extends AbstractDomain{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender")
    private User sender;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiver")
    private User receiver;
    private String message;
    private long timestamp = new Date().getTime();

    public Message(){}

    public Message(User sender, User receiver, String message, long timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters


    public User getSender() {
        return sender;
    }

    public User getReciever() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    //Setters

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReciever(User receiver) {
        this.receiver = receiver;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
