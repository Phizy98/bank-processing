package com.astakhov.example.controller;

import com.astakhov.example.DTO.TransactionDTO;
import com.astakhov.example.service.TransactionServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionServiceImp transactionServiceImp;

    @Autowired
    public TransactionController(TransactionServiceImp transactionServiceImp) {
        this.transactionServiceImp = transactionServiceImp;
    }

    @GetMapping()
    public ResponseEntity<List<TransactionDTO>> getAll() {
        List<TransactionDTO> transactions = transactionServiceImp.findAll();
        return  ResponseEntity.ok(transactions);
    }
    @GetMapping(params = "id")
    public ResponseEntity<TransactionDTO> getTransactionById(@RequestParam("id") Long id) {
        TransactionDTO transaction = transactionServiceImp.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }
    @GetMapping(params = "accountFrom")
    public ResponseEntity<List<TransactionDTO>> getTransactionByAccountFrom(@RequestParam("accountFrom") Long accountFrom) {
        List<TransactionDTO> transaction = transactionServiceImp.findAllByAccountFrom(accountFrom);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDTO> addTransaction(@RequestBody TransactionDTO transaction) {
        try {
            log.info("Accepted transactionDTO in controller: " + transaction);
            TransactionDTO savedTransaction = transactionServiceImp.addTransaction(transaction);
            log.info("Saved transaction in controller: " + savedTransaction);
            return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<Void> deleteTransaction(@RequestParam("id") Long id) {
        transactionServiceImp.deleteTransactionById(id);
        return  ResponseEntity.ok().build();
    }

}
