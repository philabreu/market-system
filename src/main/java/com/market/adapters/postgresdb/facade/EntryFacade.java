package com.market.adapters.postgresdb.facade;

import com.market.adapters.postgresdb.EntryPostgresDB;
import com.market.adapters.postgresdb.model.EntryModel;
import com.market.business.exception.ResourceNotFoundException;
import com.market.business.model.Entry;
import com.market.business.port.EntryPort;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class EntryFacade implements EntryPort {
    private final EntryPostgresDB repository;

    public EntryFacade(EntryPostgresDB repository) {
        this.repository = repository;
    }

    @Override
    public void save(Entry request) {
        EntryModel entry = new EntryModel(null,
                request.name(),
                request.type(),
                request.value(),
                request.entryDate());

        repository.save(entry);
    }

    @Override
    public Optional<EntryModel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<EntryModel> findAll() {
        return (List<EntryModel>) repository.findAll();
    }

    @Override
    public List<EntryModel> findAllByEntryDate(LocalDate entryDate) {
        return repository.findAllByEntryDate(entryDate);
    }

    @Override
    public void update(Entry entry, Long id) {
        EntryModel searchedEntry = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lançamento não encontrado com id: " + id));

        BeanUtils.copyProperties(entry, searchedEntry, "id");

        repository.save(searchedEntry);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}