package com.barbershop.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.model.CustomerModel;
import com.barbershop.model.ScheduleModel;
import com.barbershop.model.dto.ScheduleDTO;
import com.barbershop.repository.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ScheduleRepository repository;

    public List<ScheduleDTO> findByDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDateTime start = localDate.atStartOfDay();
        LocalDateTime end = localDate.plusDays(1).atStartOfDay();
        List<ScheduleModel> models = repository.findAllByHaircutDateGreaterThanEqualAndHaircutDateLessThan(start, end);

        return models.stream().map(
                m -> ScheduleDTO.toScheduleDto(m))
                .collect(Collectors.toList());
    }

    public void saveSchedule(ScheduleModel schedule) {
        CustomerModel customer = schedule.getCustomer();
        if (customer.getId() == null) {
            customerService.save(customer);
        }
        repository.save(schedule);
    }

}
