package com.agagagah.bankingv2.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String sender_rek;
    @Column(nullable = false)
    private String receiver_rek;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Transaction() {
    }

    public Transaction(Long id, String sender_rek, String receiver_rek, double amount, LocalDateTime timestamp) {
        this.id = id;
        this.sender_rek = sender_rek;
        this.receiver_rek = receiver_rek;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender_rek() {
        return sender_rek;
    }

    public void setSender_rek(String sender_rek) {
        this.sender_rek = sender_rek;
    }

    public String getReceiver_rek() {
        return receiver_rek;
    }

    public void setReceiver_rek(String receiver_rek) {
        this.receiver_rek = receiver_rek;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
