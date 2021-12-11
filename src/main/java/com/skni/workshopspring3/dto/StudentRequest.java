package com.skni.workshopspring3.dto;

import com.skni.workshopspring3.repo.entity.Course;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class StudentRequest {

    @NotBlank(message = "Please provide a name")
    @Size(min = 3, max = 12)
    private String name;

    @NotBlank(message = "Please provide a last name")
    @Size(min = 3, max = 15)
    private String lastname;

    private LocalDate birthdate;
    private GenderEnum gender;
    private Course course;
}
