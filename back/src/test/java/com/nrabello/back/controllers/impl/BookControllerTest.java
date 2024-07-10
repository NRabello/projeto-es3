package com.nrabello.back.controllers.impl;

import com.nrabello.back.domain.Book;
import com.nrabello.back.service.impl.BookFacade;
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

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookFacade bookFacade;

    private Book createBook(Long id, String title) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        return book;
    }

    @Test
    @DisplayName("Should return a list of books when successful")
    public void testFindAll() throws Exception {
        Book book1 = createBook(1L, "Book 1");
        Book book2 = createBook(2L, "Book 2");

        when(bookFacade.findAll()).thenReturn(Arrays.asList(book1, book2));

        mockMvc.perform(get("/book/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Book 1")))
                .andExpect(jsonPath("$[1].title", is("Book 2")));

        verify(bookFacade, times(1)).findAll();
    }

    @Test
    @DisplayName("Should return a book when successful")
    public void testFindById() throws Exception {
        Book book = createBook(1L, "Book 1");

        when(bookFacade.findById(anyLong())).thenReturn(book);

        mockMvc.perform(get("/book/findById").param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Book 1")));

        verify(bookFacade, times(1)).findById(anyLong());
    }

    @Test
    @DisplayName("Should save a book when successful")
    public void testSave() throws Exception {
        Book book = createBook(1L, "Book 1");

        doNothing().when(bookFacade).save(any(Book.class));

        mockMvc.perform(post("/book/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Book 1\"}"))
                .andExpect(status().isOk());

        verify(bookFacade, times(1)).save(any(Book.class));
    }

    @Test
    @DisplayName("Should update a book when successful")
    public void testUpdate() throws Exception {
        Book book = createBook(1L, "Book 1");

        doNothing().when(bookFacade).update(any(Book.class));

        mockMvc.perform(patch("/book/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Updated Book\"}"))
                .andExpect(status().isOk());

        verify(bookFacade, times(1)).update(any(Book.class));
    }
}