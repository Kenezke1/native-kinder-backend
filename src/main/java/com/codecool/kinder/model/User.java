package com.codecool.kinder.model;


import com.codecool.kinder.model.AbstractDomain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends AbstractDomain {
    private String email;
    private String givenName;
    private String familyName;
    private String imageUrl;

    User(){}

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
