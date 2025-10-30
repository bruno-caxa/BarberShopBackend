package com.barbershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.model.dto.ScheduleDTO;
import com.barbershop.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping()
    public ResponseEntity<Void> scheduleCustomer(@RequestBody ScheduleDTO schedule) {
        service.saveSchedule(schedule);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<ScheduleDTO>> getScheduleByDate(@PathVariable String date) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByDate(date));
    }

}
