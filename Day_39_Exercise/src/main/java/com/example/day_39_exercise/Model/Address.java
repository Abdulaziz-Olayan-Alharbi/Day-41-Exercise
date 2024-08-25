package com.example.day_39_exercise.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null")
    private String area;
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null")
    private String street;
    @NotNull
    @PositiveOrZero
    @Column(columnDefinition = "int not null")
    private int buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
