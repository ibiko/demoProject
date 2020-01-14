package com.example.demo.repositories;

import com.example.demo.rest.dtos.Computer;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface ComputerRepository extends CrudRepository<Computer, BigInteger> {
}
