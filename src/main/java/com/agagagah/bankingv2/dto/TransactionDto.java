package com.agagagah.bankingv2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    private String sender_rek;
    private String receiver_rek;
    private double amount;
    private LocalDateTime timestamp;
}
