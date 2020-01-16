package com.example.demo.rest.controllers;

import com.example.demo.rest.dtos.ComputerDto;
import com.example.demo.services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    private ComputerService computerService;

    @Autowired
    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping()
    public Iterable<ComputerDto> findAll() {
        return this.computerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<ComputerDto> findById(@PathVariable("id") BigInteger id) {
        return this.computerService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody ComputerDto computerDto){
        this.computerService.save(computerDto);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") BigInteger id, @RequestBody ComputerDto computerDto){
        if(computerService.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }
        this.computerService.update(computerDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") BigInteger id){
        this.computerService.deleteById(id);
    }


}
