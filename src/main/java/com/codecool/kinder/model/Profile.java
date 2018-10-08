package com.codecool.kinder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String birthDate;
    @Enumerated(EnumType.STRING)
    private Gender targetGender;
    private Integer ageLimitMin;
    private Integer ageLimitMax;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "profile")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Image> images = new ArrayList<>();

    public Profile() {}

    public Profile(Builder builder) {
        super(builder.id);
        setGender(builder.gender);
        setBirthDate(builder.birthDate);
        setTargetGender(builder.targetGender);
        setAgeLimitMin(builder.ageLimitMin);
        setAgeLimitMax(builder.ageLimitMax);
    }

    public static Builder builder(){
        return new Builder();
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

    public final static class Builder{
        Integer id;
        private Gender gender;
        private String birthDate;
        private Gender targetGender;
        private Integer ageLimitMin;
        private Integer ageLimitMax;

        public Builder(){}

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder gender(String gender){
            this.gender = Gender.valueOf(gender);
            return this;
        }

        public Builder birthDate(String birthDate){
            this.birthDate = birthDate;
            return this;
        }

        public Builder targetGender(String targetGender){
            this.targetGender = Gender.valueOf(targetGender);
            return this;
        }

        public Builder ageLimitMin(Integer ageLimitMin){
            this.ageLimitMin = ageLimitMin;
            return this;
        }

        public Builder ageLimitMax(Integer ageLimitMax){
            this.ageLimitMax = ageLimitMax;
            return this;
        }

        public Profile build(){
            return new Profile(this);
        }

    }
}
