package com.barbershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.model.CustomerModel;
import com.barbershop.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerModel findByCellPhone(String cellPhone) {
        return repository.findByCellPhone(cellPhone);
    }

    public void save(CustomerModel customer) {
        repository.save(customer);
    }
}
