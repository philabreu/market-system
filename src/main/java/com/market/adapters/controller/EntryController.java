package com.market.adapters.controller;

import com.market.adapters.controller.model.GetEntryResponse;
import com.market.adapters.controller.model.PostEntryRequest;
import com.market.adapters.controller.model.PutEntryRequest;
import com.market.business.EntryBusiness;
import com.market.business.model.Entry;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/entry")
public class EntryController {
    private final EntryBusiness entryBusiness;

    public EntryController(EntryBusiness entryBusiness) {
        this.entryBusiness = entryBusiness;
    }

    @PostMapping
    public void save(@Validated @RequestBody PostEntryRequest request) {
        entryBusiness.save(request);
    }

    @GetMapping("/{id}")
    public Entry findById(@PathVariable @NotNull Long id) {
        return entryBusiness.findById(id);
    }

    @GetMapping
    public List<GetEntryResponse> findAll() {
        return entryBusiness.findAll()
                .stream()
                .map(item -> new GetEntryResponse(
                        item.name(), item.type(), item.value(), item.entryDate())
                )
                .toList();
    }

    @GetMapping("/date/{entryDate}")
    public List<GetEntryResponse> findAllByEntryDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @NotNull LocalDate entryDate) {
        return entryBusiness.findAllByEntryDate(entryDate)
                .stream()
                .map(item -> new GetEntryResponse(
                        item.name(), item.type(), item.value(), item.entryDate())
                )
                .toList();
    }

    @PutMapping("/{id}")
    public void update(@Validated @RequestBody PutEntryRequest request, @PathVariable @NotNull Long id) {
        entryBusiness.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull Long id) {
        entryBusiness.delete(id);
    }
}