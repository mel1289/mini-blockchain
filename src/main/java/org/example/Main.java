package org.example;

import org.example.core.*;
import org.example.services.hashing.HashingSHA256Service;
import org.example.services.hashing.interfaces.HashingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        final int miningDifficulty = 1;

        SpringApplication.run(Main.class, args);

        Blockchain blockchain = new Blockchain();

        HashingService hashingService = new HashingSHA256Service();

        List<Transaction> transactionList = new ArrayList<>();

        transactionList.add(new Transaction("a", "0x0", "0x1", 100.0));
        transactionList.add(new Transaction("b", "0x0", "0x1", 200.0));
        transactionList.add(new Transaction("c", "0x0", "0x1", 300.0));
        transactionList.add(new Transaction("d", "0x2", "0x1", 400.0));

        Block block1 = new Block(1, new Date().getTime(), transactionList, "0");

        ProofOfWork proofOfWork = new ProofOfWork(blockchain, hashingService, miningDifficulty);

        proofOfWork.mineBlock(block1);

        System.out.println(blockchain.getBlocks());
    }
}