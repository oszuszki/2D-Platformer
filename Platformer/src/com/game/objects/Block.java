package com.game.objects;

import com.game.gamestate.GameState;

import java.awt.*;

public class Block extends Rectangle {
    static final long serialVersion=1L;

    public static final int blockSize=102;

    public Block(int x,int y){
        setBounds(x,y,blockSize,blockSize);
    }

    public void draw (Graphics g){
       g.fillRect(x - (int) GameState.xOffset ,y -(int) GameState.yOffset,width,height);
    }

}
