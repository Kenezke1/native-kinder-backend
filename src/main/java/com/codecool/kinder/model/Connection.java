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

    public Connection(Builder builder) {
        super(builder.id);
        setUserFrom(builder.userFrom);
        setUserTo(builder.userTo);
        setStatus(builder.status);
    }

    public static Builder builder(){
        return new Builder();
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

    public final static class Builder{
        private Integer id;
        private Integer userFrom;
        private Integer userTo;
        private Status status;

        public Builder () {}

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder userFrom(Integer userForm) {
            this.userFrom = userForm;
            return this;
        }

        public Builder userTo(Integer userTo) {
            this.userTo = userTo;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Connection build(){
            return new Connection(this);
        }
    }
}
