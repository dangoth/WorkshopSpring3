package com.skni.workshopspring3.repo.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "coursename")
    private String coursename;

    @Column(name = "year")
    private int year;

    @Column(name = "school")
    private String school;

    @Enumerated(EnumType.STRING)
    @Column(name = "coursetype")
    private CourseTypeEnum coursetype;

}
