package com.astakhov.example.service;

import com.astakhov.example.model.Transaction;
import com.astakhov.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


//    public List<Transaction> getTransactions(Long accountFrom) {
//        return transactionRepository.findAllByAccountFrom(accountFrom);
//    }
//
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
