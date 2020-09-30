package com.game.gamestate;

import com.game.entities.Player;
import com.game.objects.Block;

import java.awt.Graphics;

public class Level1State extends GameState{

    private Player player;

    private Block[] b;

    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

        player = new Player(30, 30);
        b= new Block[9];
        b[0]=new Block(100,400);
        b[1]=new Block(200,500);
        b[2]=new Block(300,500);
        b[3]=new Block(400,500);
        b[4]=new Block(500,400);
        b[5]=new Block(600,400);
        b[6]=new Block(700,300);
        b[7]=new Block(900,300);
        b[8]=new Block(600,200);

    }

    @Override
    public void tick() {
        player.tick(b);
    }

    @Override
    public void draw(Graphics g) {

        player.draw(g);
        for (int i=0 ; i<b.length;i++){
            b[i].draw(g);
        }
    }

    @Override
    public void keyPressed(int k) {
        player.keyPressed(k);
    }

    @Override
    public void keyReleased(int k) {
        player.keyReleased(k);
    }
}
