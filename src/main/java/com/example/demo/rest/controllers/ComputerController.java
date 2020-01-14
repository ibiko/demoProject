package com.example.demo.rest.controllers;

import com.example.demo.repositories.ComputerRepository;
import com.example.demo.rest.dtos.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    private ComputerRepository computerRepository;

    @Autowired
    public ComputerController(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @GetMapping()
    public Iterable<Computer> findAll() {
        return this.computerRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Computer> findById(@PathVariable("id") BigInteger id) {
        return this.computerRepository.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Computer computer){
        this.computerRepository.save(computer);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") BigInteger id, @RequestBody Computer computer){
        if(computerRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        this.computerRepository.save(computer);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") BigInteger id){
        this.computerRepository.deleteById(id);
    }


}
