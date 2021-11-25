package com.skni.workshopspring3.repo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}
