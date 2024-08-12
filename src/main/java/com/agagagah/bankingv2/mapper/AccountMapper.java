package com.agagagah.bankingv2.mapper;

import com.agagagah.bankingv2.dto.AccountDto;
import com.agagagah.bankingv2.model.Account;

public class AccountMapper {
    public static AccountDto mapToDto(Account account){
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getPin(),
                account.getRekening(),
                account.getBalance()

        );
    };

    public static Account mapToAccount(AccountDto accountDto){
        return new Account(
                accountDto.getId(),
                accountDto.getName(),
                accountDto.getPin(),
                accountDto.getRekening(),
                accountDto.getBalance()
        );
    };
}
