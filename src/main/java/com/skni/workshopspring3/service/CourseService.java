package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repo.CourseRepository;
import com.skni.workshopspring3.repo.entity.Course;
import com.skni.workshopspring3.repo.entity.CourseTypeEnum;
import com.skni.workshopspring3.repo.entity.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public boolean updateCourse(long id, Course updatedCourse) {
        Optional<Course> currentCourse = courseRepository.findById(id);
        if(currentCourse.isPresent()) {
            Course newCourse = currentCourse.get();
            if(updatedCourse.getCoursename() != null) {
                newCourse.setCoursename(updatedCourse.getCoursename());
            }
            if(updatedCourse.getSchool() != null) {
                newCourse.setSchool(updatedCourse.getSchool());
            }
            if(updatedCourse.getCoursetype() != null) {
                newCourse.setCoursetype(updatedCourse.getCoursetype());
            }
            newCourse.setYear(updatedCourse.getYear());
            newCourse.setId(id);
            courseRepository.save(newCourse);
            return true;
        }
        return false;
    }


}
