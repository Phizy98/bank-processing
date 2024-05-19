package com.astakhov.example.controller;

import com.astakhov.example.model.Transaction;
import com.astakhov.example.service.TransactionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionServiceImp transactionServiceImp;

    @Autowired
    public TransactionController(TransactionServiceImp transactionServiceImp) {
        this.transactionServiceImp = transactionServiceImp;
    }

    @GetMapping()
    public ResponseEntity<List<Transaction>> all() {
        List<Transaction> transactions = transactionServiceImp.findAll();
        return  ResponseEntity.ok(transactions);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") Long id) {
        Transaction transaction = transactionServiceImp.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        try {
            Transaction savedTransaction = transactionServiceImp.addTransaction(transaction);
            return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable("id") long id) {
        transactionServiceImp.deleteTransactionById(id);
        return  ResponseEntity.ok().build();
    }

}
