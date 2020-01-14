package com.example.demo.rest.controllers;

import com.example.demo.repositories.MotherboardRepository;
import com.example.demo.rest.dtos.Motherboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/motherboard")
public class MotherboardController {

    final MotherboardRepository motherboardRepository;

    @Autowired
    public MotherboardController(MotherboardRepository motherboardRepository) {
        this.motherboardRepository = motherboardRepository;
    }

    @GetMapping()
    public Iterable<Motherboard> findAll() {
        return motherboardRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Motherboard> findById(@PathVariable("id") BigInteger id) {
        return motherboardRepository.findById(id);
    }

    @PostMapping()
    public void save(@RequestBody Motherboard motherboard) {
        motherboardRepository.save(motherboard);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable BigInteger id, @RequestBody Motherboard motherboard) {
        if(motherboardRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        motherboardRepository.save(motherboard);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") BigInteger id) {
        motherboardRepository.deleteById(id);
    }

}
