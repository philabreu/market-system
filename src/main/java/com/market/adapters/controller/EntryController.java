package com.market.adapters.controller;

import com.market.adapters.controller.model.GetEntryResponse;
import com.market.adapters.postgresdb.model.Entry;
import com.market.business.EntryBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/entry")
@RequiredArgsConstructor
public class EntryController {
    private final EntryBusiness service;

    private static GetEntryResponse mapperToDto(Entry entry) {
        return new GetEntryResponse(entry.getName(),
                entry.getType(),
                entry.getValue(),
                entry.getEntryDate());
    }

    @GetMapping
    public ResponseEntity<List<GetEntryResponse>> findAll() {
        List<GetEntryResponse> getEntryResponseList = service.findAll()
                .stream()
                .map(EntryController::mapperToDto)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(getEntryResponseList);
    }

    @GetMapping("/{entryDate}")
    public ResponseEntity<List<GetEntryResponse>> findAllByEntryDate(@PathVariable LocalDate entryDate) {
        List<GetEntryResponse> getEntryResponseList = service.findAllByEntryDate(entryDate)
                .stream()
                .map(EntryController::mapperToDto)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(getEntryResponseList);
    }

    @PostMapping
    public ResponseEntity<GetEntryResponse> save(@RequestBody Entry entry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapperToDto(service.save(entry)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetEntryResponse> update(@Validated @RequestBody Entry entry, @PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapperToDto(service.update(entry, id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}