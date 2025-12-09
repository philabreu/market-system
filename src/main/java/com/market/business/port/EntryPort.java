package com.market.business.port;

import com.market.adapters.postgresdb.model.Entry;
import org.springframework.cache.annotation.Cacheable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface EntryPort {
    List<Entry> findAll();

    Optional<Entry> findById(Long id);

    /**
     * Cache foi usado para requisito de 500 requisicoes por segundo.
     *
     * @param entryDate
     * @return
     */
    @Cacheable("entries")
    List<Entry> findAllByEntryDate(LocalDate entryDate);

    Entry save(Entry entry);

    Entry update(Entry entry, Long id);

    void delete(Long id);
}