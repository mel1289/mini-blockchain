package org.example;

import org.example.core.Block;
import org.example.core.ProofOfWork;
import org.example.core.Transaction;
import org.example.services.hashing.HashingSHA256Service;
import org.example.services.hashing.interfaces.HashingService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final int miningDifficulty = 7;

        HashingService hashingService = new HashingSHA256Service();

        List<Transaction> transactionList = new ArrayList<>();

        transactionList.add(new Transaction("a", "0x0", "0x1", 100.0));
        transactionList.add(new Transaction("b", "0x0", "0x1", 200.0));
        transactionList.add(new Transaction("c", "0x0", "0x1", 300.0));

        Block block1 = new Block(1, new Date().getTime(), transactionList, "0");

        ProofOfWork proofOfWork = new ProofOfWork(block1, hashingService, miningDifficulty);

        proofOfWork.mineBlock();

    }
}