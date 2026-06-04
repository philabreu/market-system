package com.market.business;

import com.market.adapters.postgresdb.model.EntryModel;
import com.market.business.exception.ResourceNotFoundException;
import com.market.business.model.Entry;
import com.market.business.port.EntryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EntryBusinessTest {
    @InjectMocks
    private EntryBusiness business;

    @Mock
    private EntryPort entryPort;

    @Mock
    private EntryModel entry;

    private static final Long ID = 1L;

    @Test
    void shouldFindAllEntries() {
        when(entryPort.findAll()).thenReturn(List.of(entry));

        List<Entry> entryList = business.findAll();

        assertNotNull(entryList);

        verify(entryPort, times(1)).findAll();
    }

    @Test
    void shouldFindByEntryDate() {
        when(entryPort.findAllByEntryDate(LocalDate.now())).thenReturn(List.of(entry));

        List<Entry> result = business.findAllByEntryDate(LocalDate.now());

        assertNotNull(result);

        verify(entryPort, times(1)).findAllByEntryDate(LocalDate.now());
    }

    @Test
    void shouldFindById() {
        when(entryPort.findById(ID)).thenReturn(Optional.of(entry));

        Entry result = business.findById(ID);

        assertNotNull(result);

        verify(entryPort, times(1)).findById(ID);
    }

    @Test
    void shouldThrowExceptionWhenNotFoundEntry() {
        when(entryPort.findById(ID)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> business.findById(ID));

        verify(entryPort, times(1)).findById(ID);
    }

    @Test
    void shouldSaveEntry() {
        doNothing().when(entryPort).save(entry);

        business.save(entry);

        verify(entryPort, times(1)).save(entry);
    }

    @Test
    void shouldUpdateEntry() {
        doNothing().when(entryPort).update(entry, ID);

        business.update(entry, ID);

        verify(entryPort, times(1)).update(entry, ID);
    }

    @Test
    void shouldDeleteEntry() {
        doNothing().when(entryPort).delete(ID);

        business.delete(ID);

        verify(entryPort, times(1)).delete(ID);
    }
}