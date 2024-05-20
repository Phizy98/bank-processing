package com.astakhov.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testCreateTransaction() throws Exception {
        String jsonInput = "{" +
                "\"accountFrom\": 123456789," +
                "\"accountTo\": 987654321," +
                "\"currencyShortname\": \"USD\"," +
                "\"sum\": 1000.00," +
                "\"expenseCategory\": \"Groceries\"," +
                "\"transactionDateTime\": \"2024-04-17T09:30:00\"" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/transactions")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonInput))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountFrom").value("123456789"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountTo").value("987654321"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currencyShortname").value("USD"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sum").value(1000.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.expenseCategory").value("Groceries"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.transactionDateTime").value("2024-04-17T09:30:00"));
    }
}