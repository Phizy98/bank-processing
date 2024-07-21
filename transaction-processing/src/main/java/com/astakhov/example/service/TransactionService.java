package com.astakhov.example.service;

import com.astakhov.example.DTO.TransactionDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> findAll();
    TransactionDTO addTransaction(TransactionDTO transaction);
    TransactionDTO getTransactionById(Long id);
    void deleteTransactionById(Long id);

}
