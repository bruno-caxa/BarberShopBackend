package com.barbershop.model.dto;

import com.barbershop.model.CustomerModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String cellPhone;

    public static CustomerDTO toCustomerDto(CustomerModel c) {
        if (c == null)
            return null;
        return CustomerDTO.builder()
                .id(c.getId())
                .name(c.getName())
                .cellPhone(c.getCellPhone())
                .build();
    }

    public CustomerModel toCustomerModel() {
        return CustomerModel.builder()
                .id(this.id)
                .name(this.name)
                .cellPhone(this.cellPhone)
                .build();
    }
}
