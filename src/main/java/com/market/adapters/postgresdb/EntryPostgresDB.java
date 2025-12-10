package com.market.adapters.postgresdb;

import com.market.adapters.postgresdb.model.EntryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntryPostgresDB extends CrudRepository<EntryModel, Long> {
    List<EntryModel> findAllByEntryDate(LocalDate entryDate);
}
