package com.market.adapters.postgresdb.model;

import com.market.business.model.Entry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table
@Entity(name = "entry")
@AllArgsConstructor
@Getter
@Setter
public class EntryModel implements Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private Double value;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Override
    public String name() {
        return name;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public LocalDate entryDate() {
        return entryDate;
    }
}