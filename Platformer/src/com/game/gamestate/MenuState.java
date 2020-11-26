package com.game.gamestate;

import com.game.gamestate.game.GameState;
import com.game.gamestate.game.GameStateManager;
import com.game.main.GamePanel;


import java.awt.*;
import java.awt.event.KeyEvent;


public class MenuState extends GameState {
	private String[] options = {"Levels","Help","Quit"};
	private int currentSelection = 0;
	private String pName;

	public MenuState(GameStateManager gsm) {
		super(gsm);
		}
	public void init() {
		this.pName=GamePanel.pName;
	}
	public void tick() {
		
	}
	public void draw(Graphics g) {
		
		g.setColor(new Color(40,74,67));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		
		for (int i =0; i < options.length; i++) {
			if (i == currentSelection) {
				g.setColor(new Color(181, 224, 186));
			} else {
				g.setColor(new Color(76, 143, 130));
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
		if (k == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		if(k == KeyEvent.VK_ENTER) {
			if(currentSelection == 0) {
				gsm.states.push(new MenuLevelState(gsm,pName));
			} else if(currentSelection == 1) {
				gsm.states.push(new MenuHelpState(gsm));
			} else if(currentSelection == 2) {
				System.exit(0);
			}
		}
	}
	public void keyReleased(int k) {
		
	}
}

