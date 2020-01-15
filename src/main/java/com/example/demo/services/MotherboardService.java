package com.example.demo.services;

import com.example.demo.repositories.MotherboardRepository;
import com.example.demo.rest.dtos.Motherboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class MotherboardService {

    private final MotherboardRepository motherboardRepository;

    @Autowired
    public MotherboardService(MotherboardRepository motherboardRepository){
        this.motherboardRepository = motherboardRepository;
    }

    public Iterable<Motherboard> findAll() {
        //TODO
        return null;
    }

    public Optional<Motherboard> findById(BigInteger id) {
        //TODO
        return null;
    }

    public void save(Motherboard motherboard) {
        //TODO
    }

    public void deleteById(BigInteger id) {
        //TODO
    }
}
