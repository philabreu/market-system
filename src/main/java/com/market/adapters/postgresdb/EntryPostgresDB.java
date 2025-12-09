package com.market.adapters.postgresdb;

import com.market.adapters.postgresdb.model.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryPostgresDB extends CrudRepository<Entry, Long> {
}
