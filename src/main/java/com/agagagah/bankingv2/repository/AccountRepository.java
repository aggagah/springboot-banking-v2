package com.agagagah.bankingv2.repository;

import com.agagagah.bankingv2.dto.AccountDto;
import com.agagagah.bankingv2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByRekening(String rekening);
}

