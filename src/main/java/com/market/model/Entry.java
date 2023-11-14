package com.market.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Table
@Entity(name = "entry")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private Double value;

    @Column(name = "entry_date")
    private LocalDate entryDate;
}