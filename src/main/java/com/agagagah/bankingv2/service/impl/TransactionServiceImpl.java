package com.agagagah.bankingv2.service.impl;

import com.agagagah.bankingv2.dto.AccountDto;
import com.agagagah.bankingv2.dto.TransactionDto;
import com.agagagah.bankingv2.dto.request.TransferDto;
import com.agagagah.bankingv2.dto.request.WithdrawDto;
import com.agagagah.bankingv2.mapper.AccountMapper;
import com.agagagah.bankingv2.mapper.TranscationMapper;
import com.agagagah.bankingv2.model.Account;
import com.agagagah.bankingv2.model.Transaction;
import com.agagagah.bankingv2.repository.AccountRepository;
import com.agagagah.bankingv2.repository.TransactionRepository;
import com.agagagah.bankingv2.service.TransactionService;
import com.agagagah.bankingv2.util.BcryptEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public TransactionDto transferBalance(TransferDto dto) {
        Account findSender = accountRepository.findByRekening(dto.getSender());
        Account findReceiver = accountRepository.findByRekening(dto.getReceiver());


        if (findSender == null || findReceiver == null){
            return null;
        }

        if (!BcryptEncoder.decode(dto.getPin(), findSender.getPin())){
            throw new IllegalArgumentException("invalid PIN");
        }

        double senderBalance = findSender.getBalance() - dto.getAmount();
        double receiverBalance = findReceiver.getBalance() + dto.getAmount();

        findSender.setBalance(senderBalance);
        findReceiver.setBalance(receiverBalance);

        accountRepository.save(findSender);
        accountRepository.save(findReceiver);

        Transaction transaction = new Transaction();
        transaction.setSender_rek(findSender.getRekening());
        transaction.setReceiver_rek(findReceiver.getRekening());
        transaction.setAmount(dto.getAmount());
        transaction.setTimestamp(LocalDateTime.now());

        Transaction savedTransaction = transactionRepository.save(transaction);


        return TranscationMapper.mapToDto(savedTransaction);
    }

    @Override
    @Transactional
    public AccountDto withdrawBalance(WithdrawDto dto) {
        Account findAccount = accountRepository.findByRekening(dto.getRekening());

        if(findAccount == null){
            return null;
        }

        if(!BcryptEncoder.decode(dto.getPin(),findAccount.getPin())){
            throw new IllegalArgumentException("invalid PIN");
        }

        // set balance
        double balanceLeft = findAccount.getBalance() - dto.getAmount();
        if(balanceLeft < 0){
            throw new IllegalArgumentException("insufficient balance");
        }

        findAccount.setBalance(balanceLeft);

        Account saved = accountRepository.save(findAccount);
        return AccountMapper.mapToDto(saved);
    }

    @Override
    @Transactional
    public AccountDto depositBalance(WithdrawDto dto) {
        Account acc = accountRepository.findByRekening(dto.getRekening());

        if(acc == null){
            return null;
        }

        if(!BcryptEncoder.decode(dto.getPin(), acc.getPin())){
            throw new IllegalArgumentException("invalid pin");
        }

        double balanceLeft = acc.getBalance() + dto.getAmount();
        acc.setBalance(balanceLeft);

        Account saved = accountRepository.save(acc);
        return AccountMapper.mapToDto(saved);
    }
}
