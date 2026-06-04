package com.market.adapters.postgresdb;

import com.market.adapters.postgresdb.model.EntryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntryPostgresDB extends JpaRepository<EntryModel, Long> {
    List<EntryModel> findAllByEntryDate(LocalDate entryDate);
}