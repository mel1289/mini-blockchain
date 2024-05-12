package org.example.core;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blocks = new ArrayList<>();

    public List<Block> getBlocks() {
        return blocks;
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }
}
