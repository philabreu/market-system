package com.market.service;

import com.market.model.Entry;
import com.market.repository.EntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
        entry.setId(1L);
        entry.setName("teste");
        entry.setType("credito");
        entry.setValue(1D);
        entry.setEntryDate(LocalDate.now());

        savedEntry = new Entry();
        savedEntry.setId(1L);
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

    @Test
    public void shouldUpdateEntry(){
        when(repository.findById(1L)).thenReturn(Optional.of(savedEntry));
        when(repository.save(entry)).thenAnswer(mock -> mock.getArgument(0));

        Entry updatedEntry = service.update(entry, 1L);

        verify(repository).findById(1L);
        verify(repository).save(entry);

        assertEquals("credito", updatedEntry.getType());
    }

    @Test
    public void shouldDeleteEntry(){
        long id = 1L;

        doNothing().when(repository).deleteById(id);
        service.delete(id);

        verify(repository, times(1)).deleteById(id);
    }


}
