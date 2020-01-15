package com.example.demo.services;

import com.example.demo.repositories.ComputerRepository;
import com.example.demo.rest.dtos.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerService(ComputerRepository computerRepository){
        this.computerRepository = computerRepository;
    }

    public Iterable<Computer> findAll() {
        //TODO
        return null;
    }

    public Optional<Computer> findById(BigInteger id) {
        //TODO
        return null;
    }

    public void save(Computer computer) {
        //TODO
    }

    public void deleteById(BigInteger id) {
        //TODO
    }
}
