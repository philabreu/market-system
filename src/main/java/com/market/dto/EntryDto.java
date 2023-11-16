package com.market.dto;

import java.time.LocalDate;

public record EntryDto(
        String name,
        String type,
        Double value,
        LocalDate entryDate
) {
}