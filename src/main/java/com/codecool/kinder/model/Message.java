package com.codecool.kinder.model;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message extends AbstractDomain {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender")
    private User sender;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "connection_id")
    private Connection connection;
    private String message;
    private long timestamp;

    public Message() {
    }

    public Message(Builder builder) {
        super(builder.id);
        setSender(builder.sender);
        setConnection(builder.connection);
        setMessage(builder.message);
        setTimestamp(builder.timeStamp);
    }

    public static Builder builder() {
        return new Builder();
    }

    // Getters


    public User getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public Connection getConnection() {
        return connection;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    //Setters

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static final class Builder {
        private Integer id;
        private User sender;
        private Connection connection;
        private String message;
        private Long timeStamp;

        public Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder sender(User sender) {
            this.sender = sender;
            return this;
        }

        public Builder connection(Connection connection) {
            this.connection = connection;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder timeStamp(Long timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
