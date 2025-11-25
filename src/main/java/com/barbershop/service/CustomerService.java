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
        return CustomerDTO.toCustomerDto(repository.findByCellPhone(cellPhone).orElse(null));
    }

    public CustomerDTO save(CustomerDTO customer) {
        String cellPhone = customer.getCellPhone();
        CustomerDTO existingCustomer = findByCellPhone(cellPhone);
        if (existingCustomer != null) {
            return existingCustomer;
        }
        return CustomerDTO.toCustomerDto(repository.save(customer.toCustomerModel()));
    }
}
