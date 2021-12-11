package com.skni.workshopspring3.dto;

import com.skni.workshopspring3.repo.entity.CourseTypeEnum;
import lombok.Data;

@Data
public class CourseResponse {

    private String coursename;
    private int year;
    private String school;
    private CourseTypeEnum coursetype;
}
