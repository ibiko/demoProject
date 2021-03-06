package com.example.demo.repositories.entities;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class GraphicsCard {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column
    private String name;

    @ManyToOne(targetEntity = Computer.class)
    private Computer computer;

    public GraphicsCard() {
        //used by JPA
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
