package com.barbershop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbershop.model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    public Optional<CustomerModel> findByCellPhone(String cellPhone);
}
