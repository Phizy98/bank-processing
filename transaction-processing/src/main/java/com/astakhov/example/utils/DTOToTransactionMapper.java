package com.astakhov.example.utils;

import com.astakhov.example.DTO.TransactionDTO;
import com.astakhov.example.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

@Service
public class DTOToTransactionMapper implements Function<TransactionDTO, Transaction> {
    @Override
    public Transaction apply(TransactionDTO transaction) {
        return new Transaction(
                transaction.getId(),
                transaction.getAccountFrom(),
                transaction.getAccountTo(),
                transaction.getCurrencyShortname(),
                transaction.getSum(),
                transaction.getExpenseCategory(),
                OffsetDateTime.parse(transaction.getTransactionDateTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
                );
    }
}
