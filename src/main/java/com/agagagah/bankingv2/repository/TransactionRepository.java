package com.agagagah.bankingv2.repository;

import com.agagagah.bankingv2.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
