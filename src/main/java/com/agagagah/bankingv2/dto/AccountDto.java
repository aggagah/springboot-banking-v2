package com.agagagah.bankingv2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String name;
    private String pin;
    private String rekening;
    private double balance;

    public AccountDto(Long id, String name, String pin, String rekening, double balance) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.rekening = rekening;
        this.balance = balance;
    }
}
