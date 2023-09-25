package com.assessment.student.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "latName")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "subjects")
    private List<String> subjects;

}
