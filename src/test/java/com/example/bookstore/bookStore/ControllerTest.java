package com.example.bookstore.bookStore;

import com.example.bookstore.bookDTO.BookStore;
import com.example.bookstore.controller.BookStoreController;
import com.example.bookstore.service.BookStoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookStoreController.class)
public class ControllerTest {

    @MockBean
    private BookStoreService bookStoreService;

    @InjectMocks
    private BookStoreController bookStoreController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/home/book")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getBookByID() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/home/book/{id}",1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void addNewBook() throws Exception {
        BookStore bookStore = new BookStore(
                "hahaha",
                "Refactoring.jpg",
                "good",
                "good",
                10,
                "JAVA",
                10,
                "Active",
                "2022-01-15"
        );
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/home/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bookStore)))
                .andExpect(status().isCreated());
    }

    @Test
    @Disabled
    public void updateBook() throws Exception {
        BookStore bookStore = new BookStore(
                "hahaha",
                "Refactoring.jpg",
                "good",
                "good",
                10,
                "JAVA",
                10,
                "Active",
                "2022-01-15"
        );
        bookStore.setBookID(1032);
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/home/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bookStore)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/home/delete/{id}",1032))
                .andExpect(status().isAccepted());
    }
}
