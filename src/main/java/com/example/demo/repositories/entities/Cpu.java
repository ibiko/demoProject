package com.example.demo.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Cpu {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column
    private String name;

    public Cpu(){
        //used by JPA
    }

    public Cpu(BigInteger id, String name){
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
