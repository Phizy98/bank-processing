package com.astakhov.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "s_transactions", name = "t_transactions")
public class Transaction {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_account_from")
    private Long accountFrom;

    @Column(name = "c_account_to")
    private Long accountTo;

    @Column(name = "c_currency_shortname")
    private String currencyShortname;

    @Column(name = "c_sum")
    private Double sum;

    @Column(name = "c_category")
    private String expenseCategory;

    @Column(name = "c_transaction_datetime")
    private String transactionDateTime;
}
