package com.umanizales.micro_servicio_quiz1.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ErrorDTO {
    @NotNull
    @NotBlank
    private int codError;
    @NotNull @NotBlank
    private String errorMessage;
}
