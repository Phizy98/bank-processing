package com.astakhov.example.service;

import com.astakhov.example.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);
    List<Transaction> findAll();
    Transaction getTransactionById(Long id);
    void deleteTransactionById(Long id);
}
