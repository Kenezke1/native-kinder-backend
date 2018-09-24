package com.codecool.kinder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profiles")
public class Profile extends AbstractDomain {
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender targetGender;
    private Integer ageLimitMin;
    private Integer ageLimitMax;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "profile")
    private List<Image> images = new ArrayList<>();

    public Profile() {}

    public Profile(Integer id, Gender gender, Integer age, Gender targetGender, Integer ageLimitMin, Integer ageLimitMax) {
        super(id);
        this.gender = gender;
        this.age = age;
        this.targetGender = targetGender;
        this.ageLimitMin = ageLimitMin;
        this.ageLimitMax = ageLimitMax;
    }

    // Getters

    public User getUser() {
        return user;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getTargetGender() {
        return targetGender;
    }

    public Integer getAgeLimitMin() {
        return ageLimitMin;
    }

    public Integer getAgeLimitMax() {
        return ageLimitMax;
    }

    public List<Image> getImages() {
        return images;
    }

    // Setters


    public void setUser(User user) {
        this.user = user;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setTargetGender(Gender targetGender) {
        this.targetGender = targetGender;
    }

    public void setAgeLimitMin(Integer ageLimitMin) {
        this.ageLimitMin = ageLimitMin;
    }

    public void setAgeLimitMax(Integer ageLimitMax) {
        this.ageLimitMax = ageLimitMax;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }


    //Methods


    @Override
    public String toString() {
        return "Profile{" +
                "user=" + user +
                ", gender=" + gender +
                ", age=" + age +
                ", targetGender='" + targetGender + '\'' +
                ", ageLimitMin=" + ageLimitMin +
                ", ageLimitInt=" + ageLimitMax +
                '}';
    }
}
