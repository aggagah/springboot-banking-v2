package com.agagagah.bankingv2.service;

import com.agagagah.bankingv2.dto.AccountDto;
import com.agagagah.bankingv2.dto.TransactionDto;
import com.agagagah.bankingv2.dto.request.TransferDto;
import com.agagagah.bankingv2.dto.request.WithdrawDto;

public interface TransactionService {
    TransactionDto transferBalance(TransferDto dto);
    AccountDto withdrawBalance(WithdrawDto dto);
    AccountDto depositBalance(WithdrawDto dto);
}
