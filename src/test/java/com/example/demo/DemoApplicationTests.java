package com.example.demo;

import com.example.demo.rest.controllers.ComputerController;
import com.example.demo.rest.dtos.Computer;
import com.example.demo.rest.dtos.Cpu;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoApplicationTests {


    @Autowired
    private ComputerController computerController;

    @Test
    @Order(1)
    public void testFindAllEmpty() {
        assertThat(computerController.findAll()).isEmpty();
    }

    @Test
    @Order(2)
    public void testSave() {
        Computer computer = new Computer();
        computerController.save(computer);

        assertThat(computerController.findAll()).isNotEmpty();
        assertThat(computerController.findAll()).hasSize(1);

        Optional<Computer> optComputer = computerController.findById(BigInteger.ONE);
        assertThat(optComputer.isPresent()).isTrue();
    }

    @Test
    @Order(3)
    public void testUpdate() {
        Optional<Computer> optComputer = computerController.findById(BigInteger.ONE);
        Computer computerFromContext = optComputer.get();
        computerFromContext.setName("rendering-workstation");

        computerController.update(computerFromContext.getId(), computerFromContext);

        Optional<Computer> optComputerAfterUpdate = computerController.findById(BigInteger.ONE);
        assertThat(optComputerAfterUpdate.isPresent()).isTrue();

        assertThat(optComputerAfterUpdate.get().getName()).isEqualTo("rendering-workstation");
    }

    @Test
    @Order(4)
    public void testDelete(){
        computerController.delete(BigInteger.ONE);

        assertThat(computerController.findById(BigInteger.ONE)).isEmpty();
    }

}
