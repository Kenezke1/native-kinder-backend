package com.codecool.kinder.model;


import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    AbstractDomain(){}

    AbstractDomain(Integer id){

    }

    // Getters

    public Integer getId() {
        return id;
    }


    //Setters

    public void setId(Integer id) {
        this.id = id;
    }


    //Methods


    @Override
    public String toString() {
        return "AbstractDomain{" +
                "id=" + id +
                '}';
    }
}
