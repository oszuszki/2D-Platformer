package com.game.entities;

import com.game.main.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private boolean right = false, left = false, jumping = false, falling = false;

    private double x, y;
    private int width, height;

    private double jumpSpeed = 5;
    private double currentJumpSpeed = jumpSpeed;

    private double maxFallSpeed = 5;
    private double currentFallSpeed = 0.1;

    public Player(int width,int height) {
        x = GamePanel.WIDTH / 2;
        y = GamePanel.HEIGHT / 2;
        this.width = width;
        this.height = height;
    }
    public void tick() {
        if(right) {
            x++;
        }
        if(left){
            x--;
        }
        if(jumping) {
            y -= currentJumpSpeed;
            currentJumpSpeed -= .1;
            if(currentJumpSpeed <= 0) {
                currentJumpSpeed = jumpSpeed;
                jumping = false;
                falling = true;
            }
        }
        if(falling){
            y += currentFallSpeed;

            if(currentFallSpeed < maxFallSpeed){
                currentFallSpeed += .1;
            }
        }
        if(!falling) {
            currentFallSpeed = .1;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) x,(int) y, width, height);
    }

    public void keyPressed(int k) {
        if(k == KeyEvent.VK_D) right = true;
        if(k == KeyEvent.VK_A) left = true;
        if(k == KeyEvent.VK_W) jumping = true;
    }

    public void keyReleased(int k){
        if(k == KeyEvent.VK_D) right = false;
        if(k == KeyEvent.VK_A) left = false;
    }
}
