package com.market.business;

import com.market.adapters.postgresdb.model.EntryModel;
import com.market.business.port.EntryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EntryBusinessTest {
    @Mock
    private EntryPort entryPort;

    @InjectMocks
    private EntryBusiness service;

    private EntryModel entry;

    private EntryModel savedEntry;

    @BeforeEach
    public void setup() {
//        entry = new EntryModel();
//        entry.setId(1L);
//        entry.setName("teste");
//        entry.setType("credito");
//        entry.setValue(1D);
//        entry.setEntryDate(LocalDate.now());
//
//        savedEntry = new EntryModel();
//        savedEntry.setId(1L);
//        savedEntry.setName("teste");
//        savedEntry.setType("debito");
//        savedEntry.setValue(23D);
//        savedEntry.setEntryDate(LocalDate.now());
    }

    @Test
    public void shouldFindAllEntries() {
//        List<EntryModel> entryList = Collections.singletonList(entry);
//        when(entryPort.findAll()).thenReturn(entryList);
//
//        List<EntryModel> result = service.findAll();
//
//        assertEquals(entryList, result);
    }

    @Test
    public void shouldFindByEntryDate() {
//        List<EntryModel> entryList = Collections.singletonList(entry);
//
//        when(entryPort.findAllByEntryDate(LocalDate.now())).thenReturn(entryList);
//
//        List<EntryModel> result = service.findAllByEntryDate(LocalDate.now());
//
//        assertEquals(entryList, result);
    }

    @Test
    public void shouldSaveEntry() {
//        when(entryPort.save(entry)).thenReturn(entry);
//
//        EntryModel result = service.save(entry);
//
//        assertEquals(entry, result);
    }

    @Test
    public void shouldUpdateEntry() {
//        when(entryPort.findById(1L)).thenReturn(Optional.of(savedEntry));
//        when(entryPort.save(entry)).thenAnswer(mock -> mock.getArgument(0));
//
//        EntryModel updatedEntry = service.update(entry, 1L);
//
//        verify(entryPort).findById(1L);
//        verify(entryPort).save(entry);
//
//        assertEquals("credito", updatedEntry.getType());
    }

    @Test
    public void shouldDeleteEntry() {
        long id = 1L;

        doNothing().when(entryPort).delete(id);
        service.delete(id);

        verify(entryPort, times(1)).delete(id);
    }
}