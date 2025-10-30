package com.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbershop.model.CustomerModel;
import com.barbershop.model.dto.CustomerDTO;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    public CustomerDTO findByCellPhone(String cellPhone);
}
