package com.game.objects;

import com.game.gamestate.Game.GameState;
import com.game.resources.Images;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class Block extends Rectangle {
    static final long serialVersion = 1L;
    public static final int blockSize = 65;
    private int id;

    public Block(int x, int y, int id) {
        this.setBounds(x, y, 65, 65);
        this.id = id;
    }

    public void draw(Graphics g) {
        if (this.id == 1) {
            g.drawImage(Images.blocks[this.id - 1], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, (ImageObserver)null);
        } else if (this.id == 0) {
            g.drawImage(Images.blocks[1], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, (ImageObserver)null);
        } else if (this.id == 2) {
            g.drawImage(Images.blocks[2], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, (ImageObserver)null);
        } else if (this.id == 21) {
            g.drawImage(Images.blocks[3], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, (ImageObserver)null);
        } else if (this.id == 22) {
            g.drawImage(Images.blocks[4], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, (ImageObserver)null);
        } else if (this.id == 23) {
            g.drawImage(Images.blocks[5], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, (ImageObserver)null);
        } else if (this.id == 24) {
            g.drawImage(Images.blocks[6], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, (ImageObserver)null);
        } else if (this.id == 25) {
            g.drawImage(Images.blocks[7], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, (ImageObserver)null);
        } else if (this.id == 26) {
            g.drawImage(Images.blocks[8], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, (ImageObserver)null);
        } else if (this.id == 27) {
            g.drawImage(Images.blocks[9], this.x - (int)GameState.xOffset, this.y - (int)GameState.yOffset, this.width, this.height, (ImageObserver)null);
        } else if (this.id == 3) {
            g.drawImage(Images.blocks[14], this.x - (int) GameState.xOffset, this.y - (int) GameState.yOffset, this.width, this.height, (ImageObserver) null);
        } else if (this.id == 4) {
            g.drawImage(Images.blocks[0], this.x - (int) GameState.xOffset, this.y - (int) GameState.yOffset, this.width, this.height, (ImageObserver) null);
        }
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }
}
