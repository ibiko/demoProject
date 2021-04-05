package com.example.demo;

import com.example.demo.rest.controllers.ComputerController;
import com.example.demo.rest.dtos.ComputerDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoApplicationTests {

    @Autowired
    private ComputerController computerController;

    //TODO :: rewrite tests as @Transactional
    
    @Test
    @Order(1)
    public void testFindAllEmpty() {
        assertThat(computerController.findAll()).isEmpty();
    }

    @Test
    @Order(2)
    public void testSave() {
        ComputerDto computerDto = new ComputerDto();
        computerController.save(computerDto);

        assertThat(computerController.findAll()).isNotEmpty();
        assertThat(computerController.findAll()).hasSize(1);

        Optional<ComputerDto> optComputer = computerController.findById(BigInteger.ONE);
        assertThat(optComputer.isPresent()).isTrue();
    }

    @Test
    @Order(3)
    public void testUpdate() {
        Optional<ComputerDto> optComputer = computerController.findById(BigInteger.ONE);
        ComputerDto computerDtoFromContext = optComputer.get();
        computerDtoFromContext.setName("rendering-workstation");

        computerController.update(computerDtoFromContext.getId(), computerDtoFromContext);

        Optional<ComputerDto> optComputerAfterUpdate = computerController.findById(BigInteger.ONE);
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
