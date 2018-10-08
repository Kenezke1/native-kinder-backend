package com.codecool.kinder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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


    public Image(Builder builder) {
        super(builder.id);
        setImageUrl(builder.imageUrl);
    }

    public static Builder builder(){
        return new Builder();
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

    public final static class Builder {
        private Integer id;
        private String imageUrl;

        public Builder() {};

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Image build(){
            return new Image(this);
        }
    }
}
