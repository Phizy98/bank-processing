package com.astakhov.example.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TransactionDTO {
    private Long id;
    private Long accountFrom;
    private Long accountTo;
    private String currencyShortname;
    private Double sum;
    private String expenseCategory;
    private String transactionDateTime;
}
