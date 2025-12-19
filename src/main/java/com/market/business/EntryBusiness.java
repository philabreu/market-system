package com.market.business;

import com.market.adapters.controller.model.GetEntryResponse;
import com.market.business.exception.ResourceNotFoundException;
import com.market.business.model.Entry;
import com.market.business.port.EntryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EntryBusiness {
    private final EntryPort entryPort;

    public EntryBusiness(EntryPort entryPort) {
        this.entryPort = entryPort;
    }

    public void save(Entry request) {
        entryPort.save(request);
    }

    public Entry findById(Long id) {
        return entryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("resource not found"));
    }

    //TODO: REFATORAR PARA RETORNAR INTERFACE
    public List<GetEntryResponse> findAll() {
        return entryPort.findAll()
                .stream()
                .map(item -> new GetEntryResponse(
                        item.name(), item.type(), item.value(), item.entryDate())
                )
                .toList();
    }

    //TODO: REFATORAR PARA RETORNAR INTERFACE
    public List<GetEntryResponse> findAllByEntryDate(LocalDate entryDate) {
        return entryPort.findAllByEntryDate(entryDate)
                .stream()
                .map(item -> new GetEntryResponse(
                        item.name(), item.type(), item.value(), item.entryDate())
                )
                .toList();
    }

    public void update(Entry request, Long id) {
        entryPort.update(request, id);
    }

    public void delete(Long id) {
        entryPort.delete(id);
    }
}