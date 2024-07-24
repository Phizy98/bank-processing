package com.astakhov.example.utils;

import com.astakhov.example.DTO.TransactionDTO;
import com.astakhov.example.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class TransactionToDTOMapper implements Function<Transaction, TransactionDTO> {
    @Override
    public TransactionDTO apply(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getAccountFrom(),
                transaction.getAccountTo(),
                transaction.getCurrencyShortname(),
                transaction.getSum(),
                transaction.getExpenseCategory(),
                transaction.getTransactionDateTime().toString()
        );
    }
}
