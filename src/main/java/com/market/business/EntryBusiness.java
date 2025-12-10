package com.market.business;

import com.market.adapters.controller.model.GetEntryResponse;
import com.market.adapters.controller.model.PostEntryRequest;
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

    private static GetEntryResponse mapperToDto(Entry entry) {
        return new GetEntryResponse(entry.getName(),
                entry.getType(),
                entry.getValue(),
                entry.getEntryDate());
    }

    public List<GetEntryResponse> findAll() {
        return entryPort.findAll()
                .stream()
                .map(EntryBusiness::mapperToDto)
                .toList();
    }

    public List<GetEntryResponse> findAllByEntryDate(LocalDate entryDate) {
        return entryPort.findAllByEntryDate(entryDate)
                .stream()
                .map(EntryBusiness::mapperToDto)
                .toList();
    }

    public void save(PostEntryRequest request) {
        Entry entry = new Entry(null,
                request.name(),
                request.type(),
                request.value(),
                request.entryDate());

        entryPort.save(entry);
    }

    public Entry update(Entry entry, Long id) {
        return entryPort.update(entry, id);
    }

    public void delete(Long id) {
        entryPort.delete(id);
    }
}