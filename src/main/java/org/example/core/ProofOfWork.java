package org.example.core;

import org.example.services.hashing.interfaces.HashingService;

public class ProofOfWork {

    private Blockchain blockchain;
    private HashingService hashingService;
    private int difficulty;

    public ProofOfWork(Blockchain blockchain, HashingService hashingService, int difficulty) {
        this.blockchain = blockchain;
        this.hashingService = hashingService;
        this.difficulty = difficulty;
    }

    public boolean mineBlock(Block block) {
        try {
            final long starTime = System.currentTimeMillis();
            String target = new String(new char[difficulty]).replace('\0', '0');
            while (true) {
                String hash = hashingService.hash(block.toHashableString());
                System.out.println("[MINING] Trying this hash:  " + hash);
                if (hash.substring(0, difficulty).equals(target)) {
                    block.setHash(hash);
                    blockchain.addBlock(block);
                    System.out.println("[MINING] Hash found!: " + hash);
                    System.out.printf("[MINING] Block mined in %.2f seconds.", (System.currentTimeMillis() - starTime) / 1000.0);
                    return true;
                }
                block.incrementNonce();
            }
        } catch (Exception e) {
            System.err.println("Failed to mine block. Nonce: " + block.getNonce() + ", Hash: " + block.getHash());
            e.printStackTrace();
            throw new RuntimeException("Mining failed", e);
        }
    }
}
