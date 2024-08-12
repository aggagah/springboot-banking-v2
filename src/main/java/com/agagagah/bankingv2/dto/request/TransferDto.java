package com.agagagah.bankingv2.dto.request;

import lombok.Data;

@Data
public class TransferDto {
    private String sender;
    private String receiver;
    private double amount;
    private String pin;

    public TransferDto() {
    }

    public TransferDto(String sender, String receiver, double amount, String pin) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.pin = pin;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
