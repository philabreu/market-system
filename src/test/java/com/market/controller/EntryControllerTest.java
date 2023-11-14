package com.market.controller;

import com.market.dto.EntryDto;
import com.market.model.Entry;
import com.market.service.EntryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EntryControllerTest {
    @Mock
    private EntryService service;

    @InjectMocks
    private EntryController controller;

    private Entry entry;

    private Entry savedEntry;

    private EntryDto entryDto;

    @BeforeEach
    public void setup() {
        entry = new Entry();
        entry.setId(1);
        entry.setName("teste");
        entry.setType("credito");
        entry.setValue(2D);
        entry.setEntryDate(LocalDate.now());

        savedEntry = new Entry();
        savedEntry.setId(1);
        savedEntry.setName("teste");
        savedEntry.setType("credito");
        savedEntry.setValue(10D);
        savedEntry.setEntryDate(LocalDate.now());

        entryDto = new EntryDto();
        entryDto.setName("teste");
        entryDto.setType("credito");
        entryDto.setValue(2D);
        entryDto.setEntryDate(LocalDate.now());
    }

    @Test
    public void shouldSaveEntry() {
        when(service.save(entry)).thenReturn(entry);

        ResponseEntity<EntryDto> expected = ResponseEntity.status(HttpStatus.CREATED)
                .body(entryDto);
        ResponseEntity<EntryDto> actual = controller.save(entry);

        verify(service, times(1)).save(entry);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAllEntries() {
        when(service.findAll()).thenReturn(Arrays.asList(entry));

        ResponseEntity<List<EntryDto>> expected = ResponseEntity.status(HttpStatus.OK)
                .body(Arrays.asList(entryDto));
        ResponseEntity<List<EntryDto>> actual = controller.findAll();

        verify(service, times(1)).findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAllByEntryDate() {
        when(service.findAllByEntryDate(LocalDate.now())).
                thenReturn(Arrays.asList(entry));

        ResponseEntity<List<EntryDto>> expected = ResponseEntity.status(HttpStatus.OK)
                .body(Arrays.asList(entryDto));
        ResponseEntity<List<EntryDto>> actual = controller.findAllByEntryDate(LocalDate.now());

        verify(service, times(1)).findAllByEntryDate(LocalDate.now());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldUpdateEntry() {
        when(service.update(entry, 1)).thenReturn(savedEntry);

        ResponseEntity<EntryDto> expected = ResponseEntity.status(HttpStatus.OK)
                .body(entryDto);
        ResponseEntity<EntryDto> actual = controller.update(entry, 1);

        verify(service, times(1)).update(entry, 1);
        assertNotEquals(expected, actual);
    }

    @Disabled
    public void shouldDeleteEntry(){
    }
}
