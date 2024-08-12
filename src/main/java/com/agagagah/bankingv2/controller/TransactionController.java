package com.agagagah.bankingv2.controller;

import com.agagagah.bankingv2.dto.*;
import com.agagagah.bankingv2.dto.request.TransferDto;
import com.agagagah.bankingv2.dto.request.WithdrawDto;
import com.agagagah.bankingv2.dto.response.ErrorResponse;
import com.agagagah.bankingv2.dto.response.SuccessResponse;
import com.agagagah.bankingv2.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PutMapping("/transfer")
    public ResponseEntity<Object> transferBalance(@RequestBody TransferDto dto){
        try {

        System.out.println("Sender: "+dto.getSender());
        System.out.println("Receiver: "+dto.getReceiver());
        TransactionDto data = transactionService.transferBalance(dto);
        if(data == null){
            ErrorResponse errorResponse = new ErrorResponse("error", HttpStatus.NOT_FOUND.value(), "sender or receiver not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        SuccessResponse<TransactionDto> response = new SuccessResponse<>("success", HttpStatus.OK.value(), "success transfer "+dto.getAmount()+" from "+dto.getSender()+" to "+dto.getReceiver(), data);
        return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            ErrorResponse errorResponse = new ErrorResponse("error", HttpStatus.UNAUTHORIZED.value(), e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/withdraw")
    public ResponseEntity<Object> withdrawBalance(@RequestBody WithdrawDto dto){
        try{
            AccountDto acc = transactionService.withdrawBalance(dto);

            if(acc == null){
                ErrorResponse errorResponse = new ErrorResponse("error", HttpStatus.NOT_FOUND.value(), "sender or receiver not found");
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }

            SuccessResponse<AccountDto> response = new SuccessResponse<>("success", HttpStatus.OK.value(), "sucess withdraw amount : "+dto.getAmount(), acc);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            ErrorResponse errorResponse = new ErrorResponse("error", HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/deposit")
    public ResponseEntity<Object> depositBalance(@RequestBody WithdrawDto dto){
        try {
            AccountDto data = transactionService.depositBalance(dto);

            if(data == null){
                ErrorResponse errorResponse = new ErrorResponse("error", HttpStatus.NOT_FOUND.value(), "sender or receiver not found");
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }

            SuccessResponse<AccountDto> response = new SuccessResponse<>("success", HttpStatus.OK.value(), "sucess deposit amount : "+dto.getAmount(), data);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            ErrorResponse errorResponse = new ErrorResponse("error", HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
