package com.astakhov.example.service;

import com.astakhov.example.model.Transaction;
import com.astakhov.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImp implements  TransactionService{
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


//    public List<Transaction> getTransactions(Long accountFrom) {
//        return transactionRepository.findAllByAccountFrom(accountFrom);
//    }
//
    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }


    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }
}
