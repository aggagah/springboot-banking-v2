package com.agagagah.bankingv2.dto.request;

public class RekeningDto {
    private String rekening;
    private String pin;

    public RekeningDto() {
    }

    public RekeningDto(String rekening, String pin) {
        this.rekening = rekening;
        this.pin = pin;
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
}
