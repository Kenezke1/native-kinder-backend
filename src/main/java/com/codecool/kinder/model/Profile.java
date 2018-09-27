package com.codecool.kinder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "profiles")
public class Profile extends AbstractDomain {
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String birthDate;
    @Enumerated(EnumType.STRING)
    private Gender targetGender;
    private Integer ageLimitMin;
    private Integer ageLimitMax;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "profile")
    private List<Image> images = new ArrayList<>();

    public Profile() {}

    public Profile(Integer id, Gender gender, String birthDate, Gender targetGender, Integer ageLimitMin, Integer ageLimitMax) {
        super(id);
        this.gender = gender;
        this.birthDate = birthDate;
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

    public String getBirthDate() {
        return birthDate;
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

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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
                ", birthDate=" + birthDate +
                ", targetGender='" + targetGender + '\'' +
                ", ageLimitMin=" + ageLimitMin +
                ", ageLimitInt=" + ageLimitMax +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return gender == profile.gender &&
                Objects.equals(birthDate, profile.birthDate) &&
                targetGender == profile.targetGender &&
                Objects.equals(ageLimitMin, profile.ageLimitMin) &&
                Objects.equals(ageLimitMax, profile.ageLimitMax);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gender, birthDate, targetGender, ageLimitMin, ageLimitMax);
    }
}
