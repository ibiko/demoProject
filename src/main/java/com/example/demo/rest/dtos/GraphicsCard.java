package com.example.demo.rest.dtos;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class GraphicsCard {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column
    private String name;

    @ManyToOne
    private Computer computer;

    public GraphicsCard(){
        //used by JPA
    }

    public GraphicsCard(BigInteger id, String name){
        this.id = id;
        this.name = name;
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
}
