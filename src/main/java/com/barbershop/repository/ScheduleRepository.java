package com.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbershop.model.ScheduleModel;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleModel, Long> {

}
