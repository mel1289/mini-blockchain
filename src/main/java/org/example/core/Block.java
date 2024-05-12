package org.example.core;

import java.util.ArrayList;
import java.util.List;

public class Block {

    private int id;
    private String previousHash;
    private String hash;
    private int nonce;
    private List<Transaction> transactions;
    private long timestamp;
    private int nbrOfTransactions;

    public Block(int id, long timestamp, List<Transaction> transactions, String previousHash) {
        this.id = id;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.nonce = 0;
        this.nbrOfTransactions = 0;
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        this.nbrOfTransactions++;
    }

    public void incrementNonce() {
        this.nonce++;
    }

    public String toHashableString() {
        return id + timestamp + transactions.toString() + previousHash + nonce;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", transactions=" + transactions +
                ", previousHash='" + previousHash + '\'' +
                ", hash='" + hash + '\'' +
                ", nonce=" + nonce +
                '}';
    }
}
