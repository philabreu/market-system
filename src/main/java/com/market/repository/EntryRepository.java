package com.market.repository;

import com.market.model.Entry;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    /**
     * Cache foi usado para requisito de 500 requisicoes por segundo.
     * @param entryDate
     * @return
     */
    @Cacheable("entries")
    List<Entry> findAllByEntryDate(LocalDate entryDate);
}