package com.skni.workshopspring3.repo;

import com.skni.workshopspring3.repo.entity.CourseTypeEnum;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import com.skni.workshopspring3.repo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByLastname(String lastname);

    List<Student> findAll();


    List<Student> findAllByGenderAndCourse_Coursetype(GenderEnum gender, CourseTypeEnum coursetype);


    @Query(
            value = "SELECT distinct s.* FROM student s JOIN course c ON s.course_id = c.id " +
                    "WHERE s.name = ?1 AND c.school = ?2",
            nativeQuery = true)
    List<Student> findAllByNameAndSchool(String name, String school);
}