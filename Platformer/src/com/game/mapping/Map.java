package com.game.mapping;

import com.game.objects.Block;

import java.awt.*;

public class Map {

    private String path;
    private int width, height;

    private Block[][] blocks;


    public Map(String loadPath, int width, int height) {
        path = loadPath;
        this.width = width;
        this.height = height;

        blocks = new Block[height][width];

        for(int i = 0; i < blocks.length; i++){
            for(int j = 0; j < blocks[0].length; j++){
                blocks[i][j] = new Block(j * Block.blockSize,
                        i * Block.blockSize);

            }
        }
    }

    public void draw(Graphics g) {
        for(int i =0; i < blocks.length; i++){
            for(int j = 0; j < blocks[0].length; j++){
                blocks[i][j].draw(g);
            }
        }
    }
    public Block[][] getBlocks() {
        return blocks;
    }
}
