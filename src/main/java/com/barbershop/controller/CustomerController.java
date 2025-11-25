package com.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.model.dto.CustomerDTO;
import com.barbershop.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/cellPhone/{cellPhone}")
    public ResponseEntity<CustomerDTO> findByCellPhone(@PathVariable String cellPhone) {
        return ResponseEntity.ok(service.findByCellPhone(cellPhone));
    }
}
