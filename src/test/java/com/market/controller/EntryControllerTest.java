package com.market.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.adapters.controller.EntryController;
import com.market.adapters.controller.model.PostEntryRequest;
import com.market.adapters.controller.model.PutEntryRequest;
import com.market.business.EntryBusiness;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EntryController.class)
public class EntryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private EntryBusiness entryBusiness;

    private static final String FIND_BY_ID = "/entry/{id}";
    private static final String UPDATE_BY_ID = "/entry/{id}";
    private static final String DELETE_BY_ID = "/entry/{id}";
    private static final String FIND_BY_ENTRY_DATE = "/entry/date/{entryDate}";
    private static final Long ID = 1L;

    @Test
    public void shouldSaveEntry() throws Exception {
        PostEntryRequest postEntryRequest = new PostEntryRequest("name", "type", 10.0, LocalDate.now());

        mockMvc.perform(post("/entry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(postEntryRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldFindById() throws Exception {
        mockMvc.perform(get(FIND_BY_ID, ID))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldFindAllEntries() throws Exception {
        mockMvc.perform(get("/entry")).andExpect(status().isOk());
    }

    @Test
    public void shouldFindAllByEntryDate() throws Exception {
        mockMvc.perform(get(FIND_BY_ENTRY_DATE, LocalDate.now())).andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateEntry() throws Exception {
        PutEntryRequest putEntryRequest = new PutEntryRequest("name", "type", 10.0, LocalDate.now());

        mockMvc.perform(put(UPDATE_BY_ID, ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(putEntryRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteEntry() throws Exception {
        mockMvc.perform(delete(DELETE_BY_ID, ID)).andExpect(status().isOk());
    }
}