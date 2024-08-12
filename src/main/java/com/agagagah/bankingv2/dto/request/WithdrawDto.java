package com.agagagah.bankingv2.dto.request;

public class WithdrawDto {
    private String rekening;
    private String pin;
    private double amount;

    public WithdrawDto() {
    }

    public WithdrawDto(String rekening, String pin, double amount) {
        this.rekening = rekening;
        this.pin = pin;
        this.amount = amount;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
