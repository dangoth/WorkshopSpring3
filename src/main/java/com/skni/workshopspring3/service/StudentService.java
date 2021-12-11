package com.skni.workshopspring3.service;

import com.skni.workshopspring3.repo.StudentRepository;
import com.skni.workshopspring3.repo.entity.Course;
import com.skni.workshopspring3.repo.entity.CourseTypeEnum;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import com.skni.workshopspring3.repo.entity.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student addStudent(String name, String lastname, LocalDate birthdate, GenderEnum gender, Course course) {

        Student student = Student.builder()
                .name(name)
                .lastname(lastname)
                .birthdate(birthdate)
                .gender(gender)
                .course(course)
                .build();

        return studentRepository.save(student);
    }

    public boolean deleteStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
            return true;
        }
        return false;
    }

    public List<Student> findAllByLastName(String lastname) {
        return studentRepository.findAllByLastname(lastname);
    }

    public List<Student> getStudentByGenderAndByCourseType(GenderEnum gender, CourseTypeEnum coursetype) {
        return studentRepository.findAllByGenderAndCourse_Coursetype(gender, coursetype);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getAllByNameAndSchool(String name, String school) {
        return studentRepository.findAllByNameAndSchool(name, school);
    }

    public boolean updateStudent(long id, Student updatedStudent) {
        Optional<Student> currentStudent = studentRepository.findById(id);
        if(currentStudent.isPresent()) {
            Student newStudent = currentStudent.get();
            if(updatedStudent.getName() != null) {
                newStudent.setName(updatedStudent.getName());
            }
            if(updatedStudent.getLastname() != null) {
                newStudent.setLastname(updatedStudent.getLastname());
            }
            if(updatedStudent.getGender() != null) {
                newStudent.setGender(updatedStudent.getGender());
            }
            newStudent.setId(id);
            studentRepository.save(newStudent);
            return true;
        }
        return false;
    }


}
