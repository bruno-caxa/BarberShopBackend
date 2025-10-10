package com.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.model.ScheduleModel;
import com.barbershop.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping()
    public ResponseEntity<Void> createSchedule(@RequestBody ScheduleModel schedule) {
        service.saveSchedule(schedule);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
