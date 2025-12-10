package com.market.business.port;

import com.market.adapters.postgresdb.model.EntryModel;
import com.market.business.model.Entry;
import org.springframework.cache.annotation.Cacheable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface EntryPort {
    void save(Entry entry);

    Optional<EntryModel> findById(Long id);

    List<EntryModel> findAll();

    /**
     * Cache foi usado para requisito de 500 requisicoes por segundo.
     *
     * @param entryDate
     * @return
     */
    @Cacheable("entries")
    List<EntryModel> findAllByEntryDate(LocalDate entryDate);

    void update(Entry entry, Long id);

    void delete(Long id);
}