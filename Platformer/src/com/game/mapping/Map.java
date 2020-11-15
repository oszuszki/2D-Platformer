package com.game.mapping;

import com.game.main.GamePanel;
import com.game.objects.Block;
import com.game.objects.MovingBlocks;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Map {

    private String path;
    private String line;
    private int width, height;

    private Block[][] blocks;
    private ArrayList<MovingBlocks> movingBlocks;

    public Map(String loadPath) {
        path = loadPath;

        LoadMap();
    }

    public void draw(Graphics g) {
        for(int i =0; i < blocks.length; i++){
            for(int j = 0; j < blocks[0].length; j++){
                blocks[i][j].draw(g);
            }
        }

        for(int i = 0; i < movingBlocks.size();i++)
            movingBlocks.get(i).draw(g);
    }

    public void tick(){
        for(int i = 0; i < movingBlocks.size();i++)
            movingBlocks.get(i).tick();
    }

    public void LoadMap() {
    	InputStream is = this.getClass().getResourceAsStream(path);
    	BufferedReader br = new BufferedReader(new InputStreamReader(is));
    	
    	try {
			width = Integer.parseInt(br.readLine());
			height = Integer.parseInt(br.readLine());
			
			blocks = new Block[height][width];
			
			for(int y = 0; y < height; y++) {
			    line = br.readLine();
				String[] tokens = line.split("\\s+");
				
				for(int x = 0; x < width; x++) {
					blocks[y][x] = new Block(x * Block.blockSize, y* Block.blockSize, Integer.parseInt(tokens[x]));
				}
			}

			line = br.readLine(); // üres sor beolvasása
			line = br.readLine(); // mozgó elemek számának beolvasása
            int numberOfMovingBlocks = Integer.parseInt(line);
            movingBlocks = new ArrayList<MovingBlocks>();

            for(int i = 0 ; i < numberOfMovingBlocks; i++)
            {
                line = br.readLine();
                String[] tokens = line.split("\\s+");

                movingBlocks.add(new MovingBlocks(Integer.parseInt(tokens[0]) * Block.blockSize,
                                                    Integer.parseInt(tokens[1]) * Block.blockSize,
                                                    Integer.parseInt(tokens[2]), //id
                                                    Integer.parseInt(tokens[3]) * Block.blockSize, // balhatár
                                                    Integer.parseInt(tokens[4]) * Block.blockSize)); // jobb határ
            }
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public Block[][] getBlocks() {
        return blocks;
    }

    public ArrayList<MovingBlocks> getMovingBlocks()
    {
        return movingBlocks;
    }
}
