package com.skni.workshopspring3.dto;

import com.skni.workshopspring3.repo.entity.CourseTypeEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CourseRequest {

    @NotBlank(message = "Please provide a course name")
    @Size(min = 3, max = 26)
    private String coursename;

    private int year;
    private String school;
    private CourseTypeEnum coursetype;
}
