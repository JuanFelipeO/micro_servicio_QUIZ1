package com.umanizales.micro_servicio_quiz1.controller.DTO;

import com.umanizales.micro_servicio_quiz1.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentGradeDTO
{
    private Student student;
    private int grade;
}
