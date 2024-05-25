package com.astakhov.example.repository;

import com.astakhov.example.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findПожалуйстаAllByAccountFrom(Long accountFrom);
}
