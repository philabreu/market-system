package com.market.adapters.controller;

import com.market.adapters.controller.model.GetEntryResponse;
import com.market.adapters.controller.model.PostEntryRequest;
import com.market.adapters.postgresdb.model.Entry;
import com.market.business.EntryBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/entry")
@RequiredArgsConstructor
public class EntryController {
    private final EntryBusiness entryBusiness;

    @GetMapping
    public List<GetEntryResponse> findAll() {
        return entryBusiness.findAll();
    }

    @GetMapping("/{entryDate}")
    public List<GetEntryResponse> findAllByEntryDate(@PathVariable LocalDate entryDate) {
        return entryBusiness.findAllByEntryDate(entryDate);
    }

    @PostMapping
    public void save(@Validated @RequestBody PostEntryRequest postEntryRequest) {
        entryBusiness.save(postEntryRequest);
    }

    @PutMapping("/{id}")
    public void update(@Validated @RequestBody Entry entry, @PathVariable long id) {
        entryBusiness.update(entry, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        entryBusiness.delete(id);
    }
}