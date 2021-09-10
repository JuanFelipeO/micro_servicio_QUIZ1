package com.umanizales.micro_servicio_quiz1.model.aplication.dto;

import com.umanizales.micro_servicio_quiz1.controller.DTO.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ResponseBinaryTreeDto implements Serializable {

    private Object data;
    private String message;
    private List<ErrorDTO> errors;
}
