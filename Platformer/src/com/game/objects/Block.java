package com.game.objects;

import com.game.gamestate.GameState;
import com.game.resources.Images;

import java.awt.*;

public class Block extends Rectangle {
    static final long serialVersion=1L;

    public static final int blockSize=102;
    private int id;

    public Block(int x,int y, int id){
        setBounds(x,y,blockSize,blockSize);
        this.id = id;
    }

    public void draw (Graphics g){
    	if(id != 0)
        g.drawImage(Images.blocks[id - 1],x - (int) GameState.xOffset ,y -(int) GameState.yOffset,width,height, null);
    }
    
    public void setID(int id) {
    	this.id = id;
    }
    
    public int getID() {
    	return id;
    }

}
