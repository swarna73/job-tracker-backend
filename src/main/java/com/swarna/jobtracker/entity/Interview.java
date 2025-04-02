package com.swarna.jobtracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String stage; // e.g., Phone Screen, Tech Round, Final

    private String feedback;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private JobApplication application;
}