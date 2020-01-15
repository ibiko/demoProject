package com.example.demo.rest.controllers;

import com.example.demo.rest.dtos.Motherboard;
import com.example.demo.services.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/motherboard")
public class MotherboardController {

    final MotherboardService motherboardService;

    @Autowired
    public MotherboardController(MotherboardService motherboardService) {
        this.motherboardService = motherboardService;
    }

    @GetMapping()
    public Iterable<Motherboard> findAll() {
        return motherboardService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Motherboard> findById(@PathVariable("id") BigInteger id) {
        return motherboardService.findById(id);
    }

    @PostMapping()
    public void save(@RequestBody Motherboard motherboard) {
        motherboardService.save(motherboard);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable BigInteger id, @RequestBody Motherboard motherboard) {
        if(motherboardService.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        motherboardService.save(motherboard);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") BigInteger id) {
        motherboardService.deleteById(id);
    }

}
