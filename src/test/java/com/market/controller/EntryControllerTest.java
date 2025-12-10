package com.market.controller;

import com.market.adapters.controller.EntryController;
import com.market.adapters.controller.model.GetEntryResponse;
import com.market.adapters.postgresdb.model.EntryModel;
import com.market.business.EntryBusiness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@Disabled
@ExtendWith(MockitoExtension.class)
public class EntryControllerTest {
    @Mock
    private EntryBusiness service;

    @InjectMocks
    private EntryController controller;

    private EntryModel entry;

    private EntryModel savedEntry;

    private GetEntryResponse getEntryResponse;

    @BeforeEach
    public void setup() {
//        entry = new EntryModel();
//        entry.setId(1L);
//        entry.setName("teste");
//        entry.setType("credito");
//        entry.setValue(2D);
//        entry.setEntryDate(LocalDate.now());
//
//        savedEntry = new EntryModel();
//        savedEntry.setId(1L);
//        savedEntry.setName("teste");
//        savedEntry.setType("credito");
//        savedEntry.setValue(10D);
//        savedEntry.setEntryDate(LocalDate.now());
//
//        getEntryResponse = new GetEntryResponse("teste", "credito", 2D, LocalDate.now());
    }

    @Test
    public void shouldSaveEntry() {
//        when(service.save(entry)).thenReturn(entry);
//
//        ResponseEntity<GetEntryResponse> expected = ResponseEntity.status(HttpStatus.CREATED)
//                .body(getEntryResponse);
//        ResponseEntity<GetEntryResponse> actual = controller.save(entry);
//
//        verify(service, times(1)).save(entry);
//        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAllEntries() {
//        when(service.findAll()).thenReturn(Collections.singletonList(entry));
//
//        ResponseEntity<List<GetEntryResponse>> expected = ResponseEntity.status(HttpStatus.OK)
//                .body(Collections.singletonList(getEntryResponse));
//        ResponseEntity<List<GetEntryResponse>> actual = controller.findAll();
//
//        verify(service, times(1)).findAll();
//        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAllByEntryDate() {
//        when(service.findAllByEntryDate(LocalDate.now())).
//                thenReturn(Collections.singletonList(entry));
//
//        ResponseEntity<List<GetEntryResponse>> expected = ResponseEntity.status(HttpStatus.OK)
//                .body(Collections.singletonList(getEntryResponse));
//        ResponseEntity<List<GetEntryResponse>> actual = controller.findAllByEntryDate(LocalDate.now());
//
//        verify(service, times(1)).findAllByEntryDate(LocalDate.now());
//        assertEquals(expected, actual);
    }

    @Test
    public void shouldUpdateEntry() {
//        when(service.update(entry, 1L)).thenReturn(savedEntry);
//
//        ResponseEntity<GetEntryResponse> expected = ResponseEntity.status(HttpStatus.OK)
//                .body(getEntryResponse);
//        ResponseEntity<GetEntryResponse> actual = controller.update(entry, 1);
//
//        verify(service, times(1)).update(entry, 1L);
//        assertNotEquals(expected, actual);
    }

    @Test
    public void shouldDeleteEntry() {
//        long id = 1L;
//
//        ResponseEntity<?> response = controller.delete(id);
//
//        verify(service, times(1)).delete(id);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}