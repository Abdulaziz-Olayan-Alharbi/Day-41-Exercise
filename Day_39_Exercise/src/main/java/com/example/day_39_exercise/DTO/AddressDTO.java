package com.example.day_39_exercise.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacherId;
    @NotEmpty
    private String area;
    @NotEmpty
    private String street;
    @NotNull
    @PositiveOrZero
    private int buildingNumber;
}
