package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repo.CourseRepository;
import com.skni.workshopspring3.repo.entity.Course;
import com.skni.workshopspring3.repo.entity.CourseTypeEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course addCourse(String coursename, int year, String school, CourseTypeEnum coursetype) {
        Course course = Course.builder()
                .coursename(coursename)
                .year(year)
                .coursetype(coursetype)
                .school(school)
                .build();

        return courseRepository.save(course);
    }
}
