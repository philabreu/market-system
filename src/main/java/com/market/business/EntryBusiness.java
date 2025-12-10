package com.market.business;

import com.market.adapters.controller.model.GetEntryResponse;
import com.market.business.model.Entry;
import com.market.business.port.EntryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EntryBusiness {

    private final EntryPort entryPort;

    public void save(Entry request) {
        entryPort.save(request);
    }

    public Entry findById(Long id) {
        return entryPort.findById(id)
                .orElseThrow();
    }

    //TODO: REFATORAR PARA RETORNAR INTERFACE
    public List<GetEntryResponse> findAll() {
        return entryPort.findAll()
                .stream()
                .map(item -> new GetEntryResponse(
                        item.getName(), item.getType(), item.getValue(), item.getEntryDate())
                )
                .toList();
    }

    //TODO: REFATORAR PARA RETORNAR INTERFACE
    public List<GetEntryResponse> findAllByEntryDate(LocalDate entryDate) {
        return entryPort.findAllByEntryDate(entryDate)
                .stream()
                .map(item -> new GetEntryResponse(
                        item.getName(), item.getType(), item.getValue(), item.getEntryDate())
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