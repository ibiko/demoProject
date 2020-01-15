package com.example.demo.repositories;

import com.example.demo.repositories.entities.Motherboard;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface MotherboardRepository extends CrudRepository<Motherboard, BigInteger> {

}
