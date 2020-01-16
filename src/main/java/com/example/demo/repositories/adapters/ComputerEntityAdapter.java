package com.example.demo.repositories.adapters;

import com.example.demo.repositories.entities.Cpu;
import com.example.demo.repositories.entities.GraphicsCard;
import com.example.demo.repositories.entities.Motherboard;
import com.example.demo.rest.dtos.ComputerDto;
import com.example.demo.rest.dtos.GraphicsCardDto;

import java.util.ArrayList;
import java.util.List;

public class ComputerEntityAdapter {
    public static com.example.demo.repositories.entities.Computer createComputerEntity(ComputerDto computerDto) {
        com.example.demo.repositories.entities.Computer entity = new com.example.demo.repositories.entities.Computer();
        fillComputerFields(computerDto, entity);
        return entity;
    }

    public static void fillComputerFields(ComputerDto computerDto, com.example.demo.repositories.entities.Computer entity) {
        entity.setName(computerDto.getName());

        if(computerDto.getCpuDto() != null) {
            Cpu cpuEntity = new Cpu();
            cpuEntity.setId(computerDto.getCpuDto().getId());
            cpuEntity.setName(computerDto.getCpuDto().getName());
            entity.setCpu(cpuEntity);
        }

        if(computerDto.getMotherboardDto() != null) {
            Motherboard motherboardEntity = new Motherboard();
            motherboardEntity.setId(computerDto.getMotherboardDto().getId());
            motherboardEntity.setName(computerDto.getMotherboardDto().getName());
            entity.setMotherboard(motherboardEntity);
        }

        if(computerDto.getGraphicsCardDtoList() != null) {
            List<GraphicsCard> graphicsCardList = new ArrayList<>();
            for (GraphicsCardDto graphicsCardDto : computerDto.getGraphicsCardDtoList()) {
                GraphicsCard graphicsCardEntity = new GraphicsCard();
                graphicsCardEntity.setId(graphicsCardDto.getId());
                graphicsCardEntity.setName(graphicsCardDto.getName());
                graphicsCardList.add(graphicsCardEntity);
            }
            entity.setGraphicsCardList(graphicsCardList);
        }
    }
}
