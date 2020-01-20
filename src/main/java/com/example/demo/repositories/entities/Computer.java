package com.example.demo.repositories.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
public class Computer {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Cpu cpu;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Motherboard motherboard;

    @OneToMany(mappedBy = "computer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER, targetEntity = GraphicsCard.class)
    private List<GraphicsCard> graphicsCardList;

    public Computer() {
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

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public List<GraphicsCard> getGraphicsCardList() {
        return graphicsCardList;
    }

    public void addGraphicsCardList(GraphicsCard graphicsCard) {
        this.graphicsCardList.add(graphicsCard);
    }

    public void setGraphicsCardList(List<GraphicsCard> graphicsCardList) {
        this.graphicsCardList = graphicsCardList;
    }
}
