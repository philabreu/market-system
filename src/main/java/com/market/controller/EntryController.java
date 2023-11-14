package com.market.controller;

import com.market.dto.EntryDto;
import com.market.model.Entry;
import com.market.service.EntryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/entry")
public class EntryController {
    @Autowired
    private EntryService service;

    @GetMapping
    public ResponseEntity<List<EntryDto>> findAll() {
        List<EntryDto> entryDtoList = new ArrayList<>();

        for (Entry eachEntry : service.findAll()) {
            EntryDto entryDto = mapperToDto(eachEntry);
            entryDtoList.add(entryDto);
        }

        return ResponseEntity.status(HttpStatus.OK).body(entryDtoList);
    }

    @GetMapping("/{entryDate}")
    public ResponseEntity<List<EntryDto>> findAllByEntryDate(@PathVariable LocalDate entryDate) {
        List<EntryDto> entryDtoList = new ArrayList<>();

        for (Entry eachEntry : service.findAllByEntryDate(entryDate)) {
            EntryDto entryDto = mapperToDto(eachEntry);
            entryDtoList.add(entryDto);
        }

        return ResponseEntity.status(HttpStatus.OK).body(entryDtoList);
    }

    @PostMapping
    public ResponseEntity<EntryDto> save(@RequestBody Entry entry) {
        EntryDto entryDto = mapperToDto(service.save(entry));
        return ResponseEntity.status(HttpStatus.CREATED).body(entryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntryDto> update(@Validated @RequestBody Entry entry, @PathVariable long id) {
        EntryDto entryDto = mapperToDto(service.update(entry, id));
        return ResponseEntity.status(HttpStatus.OK).body(entryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private static EntryDto mapperToDto(Entry entry) {
        EntryDto entryDto = new EntryDto();
        BeanUtils.copyProperties(entry, entryDto, "id");
        return entryDto;
    }
}