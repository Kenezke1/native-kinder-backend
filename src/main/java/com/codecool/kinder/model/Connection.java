package com.codecool.kinder.model;


import javax.persistence.*;
@Entity
@Table(name = "connections")
public class Connection {

    private User userFrom;
    private User userTo;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Connection() {
    }

    // Getters


    public User getUserFrom() {
        return userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public Status getStatus() {
        return status;
    }

    // Setters


    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
