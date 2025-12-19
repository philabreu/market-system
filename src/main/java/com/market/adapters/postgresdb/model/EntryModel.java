package com.market.adapters.postgresdb.model;

import com.market.business.model.Entry;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Table
@Entity(name = "entry")
public record EntryModel(
        Long id,
        String name,
        String type,
        Double value,
        LocalDate entryDate
) implements Entry {
}