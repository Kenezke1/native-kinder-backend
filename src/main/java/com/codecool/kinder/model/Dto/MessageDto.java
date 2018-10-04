package com.codecool.kinder.model.Dto;

import com.codecool.kinder.model.*;

import java.util.List;

public class MessageDto {
    private User user;
    private List<Message> messages;

    public MessageDto(User user, List<Message> messages) {
        this.user = user;
        this.messages = messages;
    }

    public User getUser() {
        return user;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
