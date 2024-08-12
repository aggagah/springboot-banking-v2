package com.agagagah.bankingv2.service.impl;

import com.agagagah.bankingv2.dto.AccountDto;
import com.agagagah.bankingv2.dto.request.RekeningDto;
import com.agagagah.bankingv2.mapper.AccountMapper;
import com.agagagah.bankingv2.model.Account;
import com.agagagah.bankingv2.repository.AccountRepository;
import com.agagagah.bankingv2.service.AccountService;
import com.agagagah.bankingv2.util.BcryptEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        String encodedPin = BcryptEncoder.encode(account.getPin());
        account.setPin(encodedPin);
        Account saved = accountRepository.save(account);

        return AccountMapper.mapToDto(saved);
    }

    @Override
    public AccountDto getAccountByRekening(RekeningDto dto) {
        Account account = accountRepository.findByRekening(dto.getRekening());
        if(account == null){
            return null;
        }

        if(!BcryptEncoder.decode(dto.getPin(), account.getPin())){
            throw new IllegalArgumentException("invalid pin");
        }

        return AccountMapper.mapToDto(account);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        if(accounts.isEmpty()){
            return null;
        }

        List<AccountDto> accountDtos = new ArrayList<>();
        for (var akun: accounts){
            accountDtos.add(AccountMapper.mapToDto(akun));
        }

        return accountDtos;
    }
}
