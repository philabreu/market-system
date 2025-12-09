package com.market.adapters.postgresdb.facade;

import com.market.adapters.postgresdb.EntryPostgresDB;
import com.market.adapters.postgresdb.model.Entry;
import com.market.business.exception.ResourceNotFoundException;
import com.market.business.port.EntryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class EntryFacade implements EntryPort {
    private final EntryPostgresDB entryPostgresDB;

    @Override
    public List<Entry> findAll() {
        return (List<Entry>) entryPostgresDB.findAll();
    }

    @Override
    public Optional<Entry> findById(Long id) {
        return entryPostgresDB.findById(id);
    }

    @Override
    public List<Entry> findAllByEntryDate(LocalDate entryDate) {
        return List.of();
    }

    @Override
    public Entry save(Entry entry) {
        return null;
    }

    @Override
    public Entry update(Entry entry, Long id) {
        Entry searchedEntry = entryPostgresDB.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lançamento não encontrado com id: " + id));

        BeanUtils.copyProperties(entry, searchedEntry, "id");

        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
