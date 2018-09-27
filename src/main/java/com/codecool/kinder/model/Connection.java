package com.codecool.kinder.model;


import javax.persistence.*;
@Entity
@Table(name = "connections")
public class Connection extends AbstractDomain{

    private Integer userFrom;
    private Integer userTo;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Connection() {}

    public Connection(Integer userFrom, Integer userTo, Status status) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.status = status;
    }

    // Getters


    public Integer getUserFrom() {
        return userFrom;
    }

    public Integer getUserTo() {
        return userTo;
    }

    public Status getStatus() {
        return status;
    }

    // Setters


    public void setUserFrom(Integer userFrom) {
        this.userFrom = userFrom;
    }

    public void setUserTo(Integer userTo) {
        this.userTo = userTo;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
