package com.nrabello.back.controllers.impl;

import com.nrabello.back.domain.Book;
import com.nrabello.back.domain.Category;
import com.nrabello.back.service.impl.CategoryFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryFacade categoryFacade;

    @Test
    @DisplayName("Should return a list of categories when successful")
    public void testFindAll() throws Exception {
        Category category1 = new Category(1L, "Category 1", new ArrayList<Book>());
        Category category2 = new Category(2L, "Category 2", new ArrayList<Book>());
        List<Category> categories = Arrays.asList(category1, category2);

        when(categoryFacade.findAll()).thenReturn(categories);

        mockMvc.perform(get("/category/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Category 1")))
                .andExpect(jsonPath("$[1].name", is("Category 2")));

        verify(categoryFacade, times(1)).findAll();
    }

}