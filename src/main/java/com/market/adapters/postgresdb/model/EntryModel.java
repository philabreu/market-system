package com.market.adapters.postgresdb.model;

import com.market.business.model.Entry;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name = "entry")
@Entity(name = "entry")
public class EntryModel implements Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_name")
    private String name;

    @Column(name = "entry_type")
    private String type;

    @Column(name = "entry_value")
    private Double entryValue;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    public EntryModel() {
    }

    public EntryModel(String name, String type, Double entryValue, LocalDate entryDate) {
        this.name = name;
        this.type = type;
        this.entryValue = entryValue;
        this.entryDate = entryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getEntryValue() {
        return entryValue;
    }

    public void setEntryValue(Double entryValue) {
        this.entryValue = entryValue;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public Double entryValue() {
        return entryValue;
    }

    @Override
    public LocalDate entryDate() {
        return entryDate;
    }
}