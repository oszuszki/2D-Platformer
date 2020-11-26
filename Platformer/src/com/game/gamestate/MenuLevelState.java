package com.game.gamestate;

import com.game.gamestate.game.GameState;
import com.game.gamestate.game.GameStateManager;
import com.game.gamestate.levels.*;
import com.game.main.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.game.entities.Player.level_counter;


public class MenuLevelState extends GameState {
    private String[] options = {"Level 1","Level 2","Level 3","Level 4","Level 5","Back"};
    private int currentSelection = 0;
    private String pName;

    public MenuLevelState(GameStateManager gsm,String pName)
    {
        super(gsm);
        this.pName=pName;

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

            g.setFont(new Font("Arial", Font.PLAIN, 52));
            g.drawString(options[i], GamePanel.WIDTH / 2 - 75, 100 + i * 70);
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
            if (currentSelection < 0) {
                currentSelection = options.length - 1;
            }
        }
        if (k == KeyEvent.VK_ESCAPE){
            gsm.states.push(new MenuState(gsm));
            }

        if(k == KeyEvent.VK_ENTER) {
            if(currentSelection == 0) {
                level_counter = 1;
                gsm.states.push(new Level1State(gsm,pName));
            } else if(currentSelection == 1) {
                level_counter = 2;
                gsm.states.push(new Level1State(gsm,pName));
            } else if(currentSelection == 2) {
                level_counter = 3;
                gsm.states.push(new Level1State(gsm,pName));
            } else if(currentSelection == 3) {
                level_counter = 4;
                gsm.states.push(new Level1State(gsm,pName));
            } else if(currentSelection == 4) {
                level_counter = 5;
                gsm.states.push(new Level1State(gsm,pName));
            } else if(currentSelection == 5) {
                gsm.states.push(new MenuState(gsm));
            }

        }
    }
    public void keyReleased(int k) {

    }
}