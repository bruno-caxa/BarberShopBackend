package com.barbershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.model.dto.CustomerDTO;
import com.barbershop.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerDTO findByCellPhone(String cellPhone) {
        return repository.findByCellPhone(cellPhone);
    }

    public CustomerDTO save(CustomerDTO customer) {
        return CustomerDTO.toCustomerDto(repository.save(customer.toCustomerModel()));
    }
}
