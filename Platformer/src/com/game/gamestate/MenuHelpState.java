package com.game.gamestate;

import com.game.gamestate.Levels.Level1State;
import com.game.main.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;


public class MenuHelpState extends GameState {
    private String[] options = {"Sart","Help","Back"};
    private int currentSelection = 0;


    public MenuHelpState(GameStateManager gsm) {
        super(gsm);
    }
    public void init() {

    }
    public void tick() {

    }
    public void draw(Graphics g) {

        g.setColor(new Color(70,94,100));
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);


        for (int i =0; i < options.length; i++) {
            if (i == currentSelection) {
                g.setColor(new Color(181, 124, 86));
            } else {
                g.setColor(new Color(76, 243, 130));
            }

            g.setFont(new Font("Arial", Font.PLAIN, 72));
            g.drawString(options[i], GamePanel.WIDTH / 2 - 75, 150 + i * 150);
        }
    }
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_DOWN | k == KeyEvent.VK_S) {
            currentSelection++;
            if(currentSelection >= options.length) {
                currentSelection = 0;
            }
        }else if(k == KeyEvent.VK_UP | k == KeyEvent.VK_W) {
            currentSelection--;
            if(currentSelection<0) {
                currentSelection = options.length -1;
            }
        }
        if(k == KeyEvent.VK_ENTER) {
            if(currentSelection == 0) {

            } else if(currentSelection == 1) {

            } else if(currentSelection == 2) {
                gsm.states.push(new MenuState(gsm));
            }
        }
    }
    public void keyReleased(int k) {

    }
}