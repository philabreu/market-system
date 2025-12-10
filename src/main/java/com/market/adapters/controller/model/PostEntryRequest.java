package com.market.adapters.controller.model;

import java.time.LocalDate;

public record PostEntryRequest(
        String name,
        String type,
        Double value,
        LocalDate entryDate) {
}
