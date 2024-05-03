package org.example.core;

import org.example.services.hashing.interfaces.HashingService;

import java.util.Date;

public class ProofOfWork {

    private Block block;
    private HashingService hashingService;
    private int difficulty;

    public ProofOfWork(Block block, HashingService hashingService, int difficulty) {
        this.block = block;
        this.hashingService = hashingService;
        this.difficulty = difficulty;
    }

    public boolean mineBlock() {
        final long starTime = System.currentTimeMillis();
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (true) {
            String hash = hashingService.hash(block.toHashableString());
            System.out.println("[MINING] Trying this hash:  " + hash);
            if (hash.substring(0, difficulty).equals(target)) {
                block.setHash(hash);
                System.out.println("[MINING] Hash found!: " + hash);
                System.out.printf("[MINING] Mined in %.2f seconds.", (System.currentTimeMillis() - starTime) / 1000.0);
                return true;
            }
            block.incrementNonce();
        }
    }
}
