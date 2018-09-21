package com.codecool.kinder.model;


import com.codecool.kinder.model.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AbstractDomain {
    private String email;
    private String givenName;
    private String familyName;
    private String imageUrl;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "sender")
    @JsonIgnore
    private List<Message> sentMessages = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "receiver")
    @JsonIgnore
    private List<Message> receivedMessages = new ArrayList<>();

    public User(){}

    public User(String email, String givenName, String familyName, String imageUrl) {
        this.email = email;
        this.givenName = givenName;
        this.familyName = familyName;
        this.imageUrl = imageUrl;
    }

    // Getters


    public String getEmail() {
        return email;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }



    //Setters


    public void setEmail(String email) {
        this.email = email;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }


    // Methods


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
