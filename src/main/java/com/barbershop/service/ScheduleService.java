package com.barbershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.model.CustomerModel;
import com.barbershop.model.ScheduleModel;
import com.barbershop.repository.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ScheduleRepository repository;

    public void saveSchedule(ScheduleModel schedule) {
        CustomerModel customer = schedule.getCustomer();
        if (customer.getId() == null) {
            customerService.save(customer);
        }
        repository.save(schedule);
    }

}
