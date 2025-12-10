package com.market.adapters.controller.model;

import com.market.business.model.Entry;

import java.time.LocalDate;

public record PutEntryRequest(
        String name,
        String type,
        Double value,
        LocalDate entryDate) implements Entry {
}