package com.umanizales.micro_servicio_quiz1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Student
{
    @NotNull
    private char code;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;
    @Positive
    @NotNull
    private float note;
}
