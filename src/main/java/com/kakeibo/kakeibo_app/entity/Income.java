package com.kakeibo.kakeibo_app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Integer amount;

    private String category;

    private String memo;

    private LocalDate createdAt;
}
