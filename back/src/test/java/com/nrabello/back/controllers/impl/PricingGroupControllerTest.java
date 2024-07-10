package com.nrabello.back.controllers.impl;

import com.nrabello.back.domain.PricingGroup;
import com.nrabello.back.service.impl.PricingGroupFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PricingGroupController.class)
class PricingGroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricingGroupFacade pricingGroupFacade;

    @Test
    @DisplayName("Should return a list of pricing groups when successful")
    public void testFindAll() throws Exception {
        PricingGroup pricingGroup1 = new PricingGroup(1L, "Pricing Group 1", 12.00);
        PricingGroup pricingGroup2 = new PricingGroup(1L, "Pricing Group 2", 24.00);
        List<PricingGroup> pricingGroups = Arrays.asList(pricingGroup1, pricingGroup2);

        when(pricingGroupFacade.findAll()).thenReturn(pricingGroups);


        mockMvc.perform(get("/pricingGroup/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Pricing Group 1")))
                .andExpect(jsonPath("$[1].name", is("Pricing Group 2")));

        verify(pricingGroupFacade, times(1)).findAll();
    }
}