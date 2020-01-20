package com.example.demo.rest.adapters;

import com.example.demo.repositories.entities.Motherboard;
import com.example.demo.rest.dtos.ComputerDto;
import com.example.demo.rest.dtos.CpuDto;
import com.example.demo.rest.dtos.GraphicsCardDto;
import com.example.demo.rest.dtos.MotherboardDto;

import java.util.ArrayList;
import java.util.List;

public class ComputerDtoAdapter {
    public static ComputerDto createComputerDto(com.example.demo.repositories.entities.Computer entity) {
        CpuDto cpuDto = null;

        if (entity.getCpu() != null) {
            cpuDto = new CpuDto(entity.getCpu().getId(), entity.getCpu().getName());
        }

        MotherboardDto motherboardDto = null;

        if (entity.getMotherboard() != null) {
            motherboardDto = MotherboardDtoAdapter.createFromEntity(entity.getMotherboard());
        }

        List<GraphicsCardDto> graphicsCardDtoList = new ArrayList<>();
        if (entity.getGraphicsCardList() != null) {
            for (com.example.demo.repositories.entities.GraphicsCard graphicsCardEntity : entity.getGraphicsCardList()) {
                GraphicsCardDto graphicsCardDto = new GraphicsCardDto(graphicsCardEntity.getId(), graphicsCardEntity.getName());
                graphicsCardDtoList.add(graphicsCardDto);
            }
        }
        return new ComputerDto(entity.getId(), entity.getName(), cpuDto, motherboardDto, graphicsCardDtoList);
    }
}
