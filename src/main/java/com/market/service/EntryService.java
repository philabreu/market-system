package com.market.service;

import com.market.exception.ResourceNotFoundException;
import com.market.model.Entry;
import com.market.repository.EntryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EntryService {
    @Autowired
    private EntryRepository repository;

    public List<Entry> findAll() {
        return repository.findAll();
    }

    public List<Entry> findAllByEntryDate(LocalDate entryDate) {
        return repository.findAllByEntryDate(entryDate);
    }

    public Entry save(Entry entry) {
        return repository.save(entry);
    }

    public Entry update(Entry entry, long id) {
        Entry searchedEntry = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lançamento não encontrado com id: " + id));

        BeanUtils.copyProperties(entry, searchedEntry, "id");

        return repository.save(searchedEntry);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}