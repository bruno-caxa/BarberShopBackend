package com.barbershop.model.dto;

import java.time.LocalDateTime;

import com.barbershop.model.ScheduleModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
    private Long id;
    private LocalDateTime haircutDate;
    private CustomerDTO customer;

    public static ScheduleDTO toScheduleDto(ScheduleModel s) {
        if (s == null)
            return null;
        return ScheduleDTO.builder()
                .id(s.getId())
                .haircutDate(s.getHaircutDate())
                .customer(CustomerDTO.toCustomerDto(s.getCustomer()))
                .build();
    }

    public ScheduleModel toScheduleModel() {
        return ScheduleModel.builder()
                .id(this.id)
                .haircutDate(this.haircutDate)
                .customer(this.customer.toCustomerModel())
                .build();
    }
}
