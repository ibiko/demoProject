package com.example.demo.rest.dtos;

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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Cpu cpu;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Motherboard motherboard;

    @OneToMany(mappedBy = "computer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<GraphicsCard> graphicsCardList;

    public Computer(){
        //used by JPA
    }

    public Computer(BigInteger id, String name, Cpu cpu, Motherboard motherboard, List<GraphicsCard> graphicsCardList) {
        this.id = id;
        this.name = name;
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.graphicsCardList = graphicsCardList;
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
}