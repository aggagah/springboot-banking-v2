package com.agagagah.bankingv2.service;

import com.agagagah.bankingv2.dto.AccountDto;
import com.agagagah.bankingv2.dto.request.RekeningDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountByRekening(RekeningDto dto);

    List<AccountDto> getAllAccount();
}
