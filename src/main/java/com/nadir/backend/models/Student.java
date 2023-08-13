package com.nadir.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"classrooms"})
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @ManyToMany(mappedBy = "students")
    @EqualsAndHashCode.Exclude
    private List<Classroom> classrooms;
}
