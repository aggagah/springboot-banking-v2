package com.agagagah.bankingv2.mapper;


import com.agagagah.bankingv2.dto.TransactionDto;
import com.agagagah.bankingv2.model.Transaction;

public class TranscationMapper {
    public static TransactionDto mapToDto(Transaction transaction){
        return new TransactionDto(transaction.getId(), transaction.getSender_rek(), transaction.getReceiver_rek(), transaction.getAmount(), transaction.getTimestamp());
    }

    public static Transaction mapToTransaction(TransactionDto transactionDto){
        return new Transaction(
                transactionDto.getId(),
                transactionDto.getSender_rek(),
                transactionDto.getReceiver_rek(),
                transactionDto.getAmount(),
                transactionDto.getTimestamp()
        );
    }
}
