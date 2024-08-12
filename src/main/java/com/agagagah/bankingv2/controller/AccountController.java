package com.agagagah.bankingv2.controller;

import com.agagagah.bankingv2.dto.AccountDto;
import com.agagagah.bankingv2.dto.response.ErrorResponse;
import com.agagagah.bankingv2.dto.request.RekeningDto;
import com.agagagah.bankingv2.dto.response.SuccessResponse;
import com.agagagah.bankingv2.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Object> createAccount(@RequestBody AccountDto accountDto){
        AccountDto data = accountService.createAccount(accountDto);
        SuccessResponse<AccountDto> response = new SuccessResponse<>("success", HttpStatus.CREATED.value(), "success create new account", data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/{rekening}/detail")
    public ResponseEntity<Object> getAccountById(@RequestBody RekeningDto dto){
        try{
        AccountDto accountDto = accountService.getAccountByRekening(dto);
        if(accountDto == null){
            ErrorResponse errorResponse = new ErrorResponse("error", HttpStatus.NOT_FOUND.value(), "data not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        SuccessResponse<AccountDto> response = new SuccessResponse<>("success", HttpStatus.OK.value(), "data found", accountDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            ErrorResponse errorResponse = new ErrorResponse("error", HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping()
    public ResponseEntity<Object> getAllAccount(){
        List<AccountDto> accountDtos = accountService.getAllAccount();
        if(accountDtos == null){
            ErrorResponse errorResponse = new ErrorResponse("error", HttpStatus.NOT_FOUND.value(), "data not found");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        SuccessResponse<List<AccountDto>> response = new SuccessResponse<>("success", HttpStatus.OK.value(), "data found", accountDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
