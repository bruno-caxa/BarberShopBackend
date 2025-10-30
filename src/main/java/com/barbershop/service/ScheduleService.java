package com.barbershop.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barbershop.model.ScheduleModel;
import com.barbershop.model.dto.CustomerDTO;
import com.barbershop.model.dto.ScheduleDTO;
import com.barbershop.repository.ScheduleRepository;


@Service
public class ScheduleService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ScheduleRepository repository;

    @Transactional(readOnly = true)
    public List<ScheduleDTO> findByDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDateTime start = localDate.atStartOfDay();
        LocalDateTime end = localDate.plusDays(1).atStartOfDay();
        List<ScheduleModel> models = repository.findAllByHaircutDateGreaterThanEqualAndHaircutDateLessThan(start, end);

        return models.stream().map(
                m -> ScheduleDTO.toScheduleDto(m))
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveSchedule(ScheduleDTO schedule) {
        CustomerDTO customerDto = schedule.getCustomer();

        if (customerDto.getId() == null || customerDto.getId() == 0) {
            customerDto = customerService.save(customerDto);
            schedule.setCustomer(customerDto);
        }
        repository.save(schedule.toScheduleModel());
    }

}
