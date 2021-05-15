package com.xfactor.lably.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_test")
public class Test {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long Id;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    private String name;

    @Column(name="desc")
    private String description;

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
