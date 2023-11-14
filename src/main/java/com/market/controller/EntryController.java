package com.market.controller;

import com.market.model.Entry;
import com.market.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService service;

    @GetMapping
    public ResponseEntity<List<Entry>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Entry> save(@RequestBody Entry entry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entry));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entry> update(@Validated @RequestBody Entry entry, @PathVariable long id) {
        Entry updatedEntry = service.update(entry, id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
