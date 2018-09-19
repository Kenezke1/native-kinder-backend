package com.codecool.kinder.model;


import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean enabled = true;

    AbstractDomain(){}

    // Getters

    public Integer getId() {
        return id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //Methods


    @Override
    public String toString() {
        return "AbstractDomain{" +
                "id=" + id +
                ", enabled=" + enabled +
                '}';
    }
}
