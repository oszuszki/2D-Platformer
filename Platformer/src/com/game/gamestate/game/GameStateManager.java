package com.game.gamestate.game;

import com.game.gamestate.MenuState;

import java.awt.*;
import java.util.Stack;


public class GameStateManager {

	public static Stack<GameState> states;

	public GameStateManager() {
		states = new Stack<GameState>();
		states.push(new MenuState(this));
	}

	public void tick() {
		states.peek().tick();
	}
	public void draw(Graphics g) {
		states.peek().draw(g);
	}
	public void keyPressed(int k) {
		states.peek().keyPressed(k);
	}
	public void keyReleased(int k) {
		states.peek().keyReleased(k);
	}


}
