package com.market.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EntryDto {
    private String name;
    private String type;
    private Double value;
    private LocalDate entryDate;
}