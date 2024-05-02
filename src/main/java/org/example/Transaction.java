package org.example;

import java.util.UUID;

public class Transaction {

    private final String id;
    private final String sender;
    private final String receiver;
    private final Double amount;

    public Transaction(String id, String sender, String receiver, Double amount) {
        this.id = UUID.randomUUID().toString();
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                "sender='" + sender + '\'' +
                ", recipient='" + receiver + '\'' +
                ", amount=" + amount +
                '}';
    }
}
