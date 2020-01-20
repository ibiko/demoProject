package com.example.demo.repositories.adapters;

import com.example.demo.repositories.entities.Cpu;
import com.example.demo.repositories.entities.GraphicsCard;
import com.example.demo.repositories.entities.Motherboard;
import com.example.demo.rest.dtos.ComputerDto;
import com.example.demo.rest.dtos.GraphicsCardDto;

import java.math.BigInteger;
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

        if (computerDto.getCpuDto() != null) {
            Cpu cpuEntity = createCpuEntity(setNullIfZero(computerDto.getCpuDto().getId()), computerDto.getCpuDto().getName());
            entity.setCpu(cpuEntity);
        }

        if (computerDto.getMotherboardDto() != null) {
            Motherboard motherboardEntity = createMotherboardEntity(setNullIfZero(computerDto.getMotherboardDto().getId()), computerDto.getMotherboardDto().getName());
            entity.setMotherboard(motherboardEntity);
        }

        if (computerDto.getGraphicsCardDtoList() != null) {
            List<GraphicsCard> graphicsCardList = new ArrayList<>();
            for (GraphicsCardDto graphicsCardDto : computerDto.getGraphicsCardDtoList()) {
                GraphicsCard graphicsCardEntity = createGraphicsCardEntity(setNullIfZero(graphicsCardDto.getId()), graphicsCardDto.getName());

                /* the GraphicsCard is the owner of the relationship, that is why the Computer needs to be set here,
                otherwise the relationship would hot have been persisted. */
                graphicsCardEntity.setComputer(entity);

                graphicsCardList.add(graphicsCardEntity);
            }
            entity.setGraphicsCardList(graphicsCardList);
        }
    }

    private static BigInteger setNullIfZero(BigInteger id) {
        if (id != null && BigInteger.ZERO.compareTo(id) == 0) {
            return null;
        }
        return id;
    }

    private static GraphicsCard createGraphicsCardEntity(BigInteger id, String name) {
        GraphicsCard graphicsCardEntity = new GraphicsCard();
        graphicsCardEntity.setId(id);
        graphicsCardEntity.setName(name);
        return graphicsCardEntity;
    }

    private static Motherboard createMotherboardEntity(BigInteger id, String name) {
        Motherboard motherboardEntity = new Motherboard();
        motherboardEntity.setId(id);
        motherboardEntity.setName(name);
        return motherboardEntity;
    }

    private static Cpu createCpuEntity(BigInteger id, String name) {
        Cpu cpuEntity = new Cpu();
        cpuEntity.setId(id);
        cpuEntity.setName(name);
        return cpuEntity;
    }
}
