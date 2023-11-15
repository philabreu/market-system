package com.market.service;

import com.market.model.Entry;
import com.market.repository.EntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EntryServiceTest {
    @Mock
    private EntryRepository repository;

    @InjectMocks
    private EntryService service;

    private Entry entry;

    private Entry savedEntry;

    @BeforeEach
    public void setup() {
        entry = new Entry();
        entry.setId(1);
        entry.setName("teste");
        entry.setType("credito");
        entry.setValue(1D);
        entry.setEntryDate(LocalDate.now());

        savedEntry = new Entry();
        savedEntry.setId(1);
        savedEntry.setName("teste");
        savedEntry.setType("debito");
        savedEntry.setValue(23D);
        savedEntry.setEntryDate(LocalDate.now());
    }

    @Test
    public void shouldFindAllEntries() {
        List<Entry> entryList = Arrays.asList(entry);
        when(repository.findAll()).thenReturn(entryList);

        List<Entry> result = service.findAll();

        assertEquals(entryList, result);
    }

    @Test
    public void shouldFindByEntryDate() {
        List<Entry> entryList = Arrays.asList(entry);

        when(repository.findAllByEntryDate(LocalDate.now())).thenReturn(entryList);

        List<Entry> result = service.findAllByEntryDate(LocalDate.now());

        assertEquals(entryList, result);
    }

    @Test
    public void shouldSaveEntry() {
        when(repository.save(entry)).thenReturn(entry);

        Entry result = service.save(entry);

        assertEquals(entry, result);
    }

    @Disabled("TO DO")
    public void shouldUpdateEntry(){
    }
}
