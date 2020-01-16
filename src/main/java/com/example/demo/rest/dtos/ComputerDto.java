package com.example.demo.rest.dtos;

import java.math.BigInteger;
import java.util.List;

public class ComputerDto {

    private BigInteger id;
    private String name;
    private CpuDto cpuDto;
    private MotherboardDto motherboardDto;
    private List<GraphicsCardDto> graphicsCardDtoList;

    public ComputerDto(){
        //Default
    }

    public ComputerDto(BigInteger id, String name, CpuDto cpuDto, MotherboardDto motherboardDto, List<GraphicsCardDto> graphicsCardDtoList) {
        this.id = id;
        this.name = name;
        this.cpuDto = cpuDto;
        this.motherboardDto = motherboardDto;
        this.graphicsCardDtoList = graphicsCardDtoList;
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

    public CpuDto getCpuDto() {
        return cpuDto;
    }

    public void setCpuDto(CpuDto cpuDto) {
        this.cpuDto = cpuDto;
    }

    public MotherboardDto getMotherboardDto() {
        return motherboardDto;
    }

    public void setMotherboardDto(MotherboardDto motherboardDto) {
        this.motherboardDto = motherboardDto;
    }

    public List<GraphicsCardDto> getGraphicsCardDtoList() {
        return graphicsCardDtoList;
    }

    public void addGraphicsCardList(GraphicsCardDto graphicsCardDto) {
        this.graphicsCardDtoList.add(graphicsCardDto);
    }
}
