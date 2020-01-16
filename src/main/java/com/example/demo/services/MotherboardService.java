package com.example.demo.services;

import com.example.demo.rest.adapters.MotherboardDtoAdapter;
import com.example.demo.repositories.MotherboardRepository;
import com.example.demo.rest.dtos.MotherboardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MotherboardService {

    private final MotherboardRepository motherboardRepository;

    @Autowired
    public MotherboardService(MotherboardRepository motherboardRepository){
        this.motherboardRepository = motherboardRepository;
    }

    public Iterable<MotherboardDto> findAll() {
        ArrayList<MotherboardDto> result = new ArrayList<>();
        for(com.example.demo.repositories.entities.Motherboard entity : this.motherboardRepository.findAll()){
            result.add(MotherboardDtoAdapter.createFromEntity(entity));
        }
        return result;
    }

    public Optional<MotherboardDto> findById(BigInteger id) {
        Optional<com.example.demo.repositories.entities.Motherboard> optMotherboard = this.motherboardRepository.findById(id);

        if(optMotherboard.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(MotherboardDtoAdapter.createFromEntity(optMotherboard.get()));
    }

    public void save(MotherboardDto motherboardDto) {
        com.example.demo.repositories.entities.Motherboard entity = new com.example.demo.repositories.entities.Motherboard();
        entity.setName(motherboardDto.getName());
        this.motherboardRepository.save(entity);
    }

    public void update(MotherboardDto motherboardDto) {
        Optional<com.example.demo.repositories.entities.Motherboard> optMotherboard = this.motherboardRepository.findById(motherboardDto.getId());

        if(optMotherboard.isEmpty()){
            throw new EntityNotFoundException();
        }

        com.example.demo.repositories.entities.Motherboard entity = optMotherboard.get();
        entity.setName(motherboardDto.getName());
        this.motherboardRepository.save(entity);
    }

    public void deleteById(BigInteger id) {
       this.motherboardRepository.deleteById(id);
    }
}
