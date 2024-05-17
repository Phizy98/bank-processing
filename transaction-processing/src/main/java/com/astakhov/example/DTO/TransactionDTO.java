package com.astakhov.example.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TransactionDTO {
    private Long id;
    private Long accountFrom;
    private Long accountTo;
    private String currencyShortname;
    private Double sum;
    private String expenseCategory;
    private String transactionDateTime;
}
