package com.market.adapters.controller;

import com.market.adapters.controller.model.GetEntryResponse;
import com.market.adapters.controller.model.PostEntryRequest;
import com.market.adapters.controller.model.PutEntryRequest;
import com.market.business.EntryBusiness;
import com.market.business.model.Entry;
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

    @PostMapping
    public void save(@Validated @RequestBody PostEntryRequest request) {
        entryBusiness.save(request);
    }

    @GetMapping("/id")
    public Entry findById(Long id) {
        return entryBusiness.findById(id);
    }

    @GetMapping
    public List<GetEntryResponse> findAll() {
        return entryBusiness.findAll();
    }

    @GetMapping("/{entryDate}")
    public List<GetEntryResponse> findAllByEntryDate(@PathVariable LocalDate entryDate) {
        return entryBusiness.findAllByEntryDate(entryDate);
    }

    @PutMapping("/{id}")
    public void update(@Validated @RequestBody PutEntryRequest request, @PathVariable Long id) {
        entryBusiness.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        entryBusiness.delete(id);
    }
}