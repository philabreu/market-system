package com.market.business;

import com.market.adapters.postgresdb.model.Entry;
import com.market.business.port.EntryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EntryBusiness {

    private final EntryPort entryPort;

    public List<Entry> findAll() {
        return entryPort.findAll();
    }

    public List<Entry> findAllByEntryDate(LocalDate entryDate) {
        return entryPort.findAllByEntryDate(entryDate);
    }

    public Entry save(Entry entry) {
        return entryPort.save(entry);
    }

    public Entry update(Entry entry, Long id) {
        return entryPort.update(entry, id);
    }

    public void delete(Long id) {

        entryPort.delete(id);
    }
}