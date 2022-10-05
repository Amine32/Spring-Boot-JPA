package com.example.spring_boot_2022.student;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@Getter @Setter
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
         strategy = GenerationType.SEQUENCE,
         generator = "student_sequence"
    )
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private LocalDate dob;

    @Transient
    private Integer age;

    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
