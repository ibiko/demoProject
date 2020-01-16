package com.example.demo.services;

import com.example.demo.repositories.adapters.ComputerEntityAdapter;
import com.example.demo.rest.adapters.ComputerDtoAdapter;
import com.example.demo.repositories.ComputerRepository;
import com.example.demo.rest.dtos.ComputerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerService(ComputerRepository computerRepository){
        this.computerRepository = computerRepository;
    }

    public Iterable<ComputerDto> findAll() {
        ArrayList<ComputerDto> result = new ArrayList<>();
        for(com.example.demo.repositories.entities.Computer entity : this.computerRepository.findAll()){
            result.add(ComputerDtoAdapter.createComputerDto(entity));
        }
        return result;
    }

    public Optional<ComputerDto> findById(BigInteger id) {
        Optional<com.example.demo.repositories.entities.Computer> optComputer = this.computerRepository.findById(id);

        if(optComputer.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(ComputerDtoAdapter.createComputerDto(optComputer.get()));
    }

    public void save(ComputerDto computerDto) {
        this.computerRepository.save(ComputerEntityAdapter.createComputerEntity(computerDto));
    }

    public void update(ComputerDto computerDto) {
        Optional<com.example.demo.repositories.entities.Computer> optComputer = this.computerRepository.findById(computerDto.getId());

        if(optComputer.isEmpty()){
            throw new EntityNotFoundException();
        }

        com.example.demo.repositories.entities.Computer entity = optComputer.get();
        ComputerEntityAdapter.fillComputerFields(computerDto, entity);
        this.computerRepository.save(entity);
    }

    public void deleteById(BigInteger id) {
        this.computerRepository.deleteById(id);
    }
}
