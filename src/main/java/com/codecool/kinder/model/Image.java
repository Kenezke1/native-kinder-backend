package com.codecool.kinder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image extends AbstractDomain {
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "profile_id",nullable = false)
    @JsonIgnore
    private Profile profile;
    private String imageUrl;


    public Image() {}

    public Image(Profile profile, String imageUrl) {
        this.profile = profile;
        this.imageUrl = imageUrl;
    }

    //Getters


    public Profile getProfile() {
        return profile;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    //Setters


    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Methods


    @Override
    public String toString() {
        return "Image{" +
                "profile=" + profile +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
