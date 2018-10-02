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

    public User(Builder builder) {
        super(builder.id);
        setEmail(builder.email);
        setGivenName(builder.givenName);
        setFamilyName(builder.familyName);
        setImageUrl(builder.imageUrl);
    }

    public static Builder builder(){
        return new Builder();
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

    public final static class Builder{
        private Integer id;
        private String email;
        private String givenName;
        private String familyName;
        private String imageUrl;

        public Builder(){}

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder givenName(String givenName){
            this.givenName = givenName;
            return this;
        }

        public Builder failiName(String familyName){
            this.familyName = familyName;
            return this;
        }

        public Builder imageUrl(){
            this.imageUrl = imageUrl;
            return this;
        }


        public User build(){
            return new User(this);
        }
    }
}
