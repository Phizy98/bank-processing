package com.astakhov.example.service;

import com.astakhov.example.DTO.TransactionDTO;
import com.astakhov.example.model.Transaction;
import com.astakhov.example.repository.TransactionRepository;
import com.astakhov.example.utils.DTOToTransactionMapper;
import com.astakhov.example.utils.TransactionToDTOMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class TransactionServiceImp implements  TransactionService{
    private final TransactionRepository transactionRepository;
    private final TransactionToDTOMapper transactionToDTOMapper;

    private final DTOToTransactionMapper dtoToTransactionMapper = new DTOToTransactionMapper();

    @Autowired
    public TransactionServiceImp(
            TransactionRepository transactionRepository,
            TransactionToDTOMapper transactionToDTOMapper
    ) {
        this.transactionRepository = transactionRepository;
        this.transactionToDTOMapper = transactionToDTOMapper;
    }


    @Override
    public List<TransactionDTO> findAll() {
        return transactionRepository.
                findAll().
                stream().
                map(transactionToDTOMapper).
                collect(Collectors.toList());
    }

    public List<TransactionDTO> findAllByAccountFrom(Long accountFrom) {
        return transactionRepository.
                findAllByAccountFrom(accountFrom).
                stream().
                map(transactionToDTOMapper).
                collect(Collectors.toList());
    }

    @Override
    public TransactionDTO addTransaction(TransactionDTO transaction) {
        log.info("Accepted transactionDTO in service: " + transaction);
        TransactionDTO saved = transactionToDTOMapper.apply(transactionRepository.save(dtoToTransactionMapper.apply(transaction)));
        log.info("Saved in DB transaction in service: " + saved);
        return saved;
    }


    @Override
    public TransactionDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        return transaction == null ? null : transactionToDTOMapper.apply(transaction);
    }
    @Override
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }
}
