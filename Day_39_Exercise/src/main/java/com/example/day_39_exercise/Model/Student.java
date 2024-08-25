package com.example.day_39_exercise.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull
    @PositiveOrZero
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String major;
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
