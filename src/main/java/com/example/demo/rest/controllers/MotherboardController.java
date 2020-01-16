package com.example.demo.rest.controllers;

import com.example.demo.rest.dtos.MotherboardDto;
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
    public Iterable<MotherboardDto> findAll() {
        return motherboardService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<MotherboardDto> findById(@PathVariable("id") BigInteger id) {
        return motherboardService.findById(id);
    }

    @PostMapping()
    public void save(@RequestBody MotherboardDto motherboardDto) {
        motherboardService.save(motherboardDto);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable BigInteger id, @RequestBody MotherboardDto motherboardDto) {
        if(motherboardService.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        motherboardService.update(motherboardDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") BigInteger id) {
        motherboardService.deleteById(id);
    }

}
