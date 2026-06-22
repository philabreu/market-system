package com.market.business.model;

import java.time.LocalDate;

public interface Entry {
    String name();

    String type();

    Double entryValue();

    LocalDate entryDate();
}