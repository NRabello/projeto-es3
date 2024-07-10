package com.nrabello.back.controllers.impl;

import com.nrabello.back.domain.Book;
import com.nrabello.back.domain.ReasonActivationDeactivation;
import com.nrabello.back.service.impl.ReasonActivationDeactivationFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ReasonActivationDeactivationController.class)
class ReasonActivationDeactivationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReasonActivationDeactivationFacade facade;

    @Test
    @DisplayName("Should return a list of reasons when successful")
    public void testFindAll() throws Exception {
        Book book = new Book(1L, "Title", null, 10.0, "Synopsis", null, "2022", null, "1st", "ISBN", 200, null, null, "1234567890", true);
        ReasonActivationDeactivation reason1 = new ReasonActivationDeactivation(1L, "Reason 1", book, "Type 1");
        ReasonActivationDeactivation reason2 = new ReasonActivationDeactivation(2L, "Reason 2", book, "Type 2");
        List<ReasonActivationDeactivation> reasons = Arrays.asList(reason1, reason2);

        when(facade.findAll()).thenReturn(reasons);

        mockMvc.perform(get("/reason/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].description", is("Reason 1")))
                .andExpect(jsonPath("$[1].description", is("Reason 2")));

        verify(facade, times(1)).findAll();
    }

    @Test
    @DisplayName("Should save a reason when successful")
    public void testSave() throws Exception {
        Book book = new Book(1L, "Title", null, 10.0, "Synopsis", null, "2022", null, "1st", "ISBN", 200, null, null, "1234567890", true);
        ReasonActivationDeactivation reason = new ReasonActivationDeactivation(1L, "Reason", book, "Type");

        doNothing().when(facade).save(any(ReasonActivationDeactivation.class));

        mockMvc.perform(post("/reason/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"description\":\"Reason\",\"type\":\"Type\",\"book\":{\"id\":1,\"title\":\"Title\"}}"))
                .andExpect(status().isOk());

        verify(facade, times(1)).save(any(ReasonActivationDeactivation.class));
    }
}