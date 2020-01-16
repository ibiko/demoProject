package com.example.demo.rest.adapters;

import com.example.demo.rest.dtos.MotherboardDto;

public class MotherboardDtoAdapter {
    public static MotherboardDto createFromEntity(com.example.demo.repositories.entities.Motherboard entity) {
        return new MotherboardDto(entity.getId(), entity.getName());
    }
}
