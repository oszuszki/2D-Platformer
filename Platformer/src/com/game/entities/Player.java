package com.game.entities;

import com.game.gamestate.Game.GameState;
import com.game.gamestate.Game.GameStateManager;
import com.game.gamestate.Levels.Level2State;
import com.game.main.GamePanel;
import com.game.objects.Block;
import com.game.physics.Collison;
import com.game.resources.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.Random;

public class Player {

	private boolean right = false, left = false, jumping = false, falling = false;

	private double x, y;
	private int width, height;

	private double jumpSpeed = 5;
	private double currentJumpSpeed = jumpSpeed;

	private boolean  portal = false;
	public static int level_counter = 1;

	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;

	private boolean topCollision = false;
	private double moveSpeed = 2.5;

	private int x_pic = 170;
	private int y_pic = 183;
	int left_animation, right_animation;
	int Lframecounter, Rframecounter;

	private GameStateManager gsm;

	public Player(int width, int height) {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}

	public void tick(Block[][] b) { //portal
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j].getID() == 2) {
					// right
					if (Collison
							.playerBlock(new Point((int) x + width + (int) GameState.xOffset,
									(int) y + (int) GameState.yOffset + 2), b[i][j])
							|| Collison.playerBlock(new Point((int) x + width + (int) GameState.xOffset,
							(int) y + height + (int) GameState.yOffset - 1), b[i][j])) {
						portal = true;
				}}}}

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j].getID() == 1) {
					// right
					if (Collison
							.playerBlock(new Point((int) x + width + (int) GameState.xOffset,
									(int) y + (int) GameState.yOffset + 2), b[i][j])
							|| Collison.playerBlock(new Point((int) x + width + (int) GameState.xOffset,
									(int) y + height + (int) GameState.yOffset - 1), b[i][j])) {
						right = false;
					}
					// left
					if (Collison
							.playerBlock(new Point((int) x + (int) GameState.xOffset - 1,
									(int) y + (int) GameState.yOffset + 2), b[i][j])
							|| Collison.playerBlock(new Point((int) x + (int) GameState.xOffset - 2,
									(int) y + height + (int) GameState.yOffset - 1), b[i][j])) {
						left = false;
					}
					// top
					if (Collison.playerBlock(
							new Point((int) x + (int) GameState.xOffset + 2, (int) y + (int) GameState.yOffset),
							b[i][j])
							|| Collison.playerBlock(new Point((int) x + width + (int) GameState.xOffset - 2,
									(int) y + (int) GameState.yOffset), b[i][j])) {
						jumping = false;
						falling = true;
					}
					// bottom
					if (Collison
							.playerBlock(new Point((int) x + (int) GameState.xOffset + 2,
									(int) y + height + (int) GameState.yOffset + 1), b[i][j])
							|| Collison.playerBlock(new Point((int) x + width + (int) GameState.xOffset - 2,
									(int) y + height + (int) GameState.yOffset + 1), b[i][j])) {
						y = b[i][j].getY() - height - GameState.yOffset;
						falling = false;
						topCollision = true;
					} else {
						if (!topCollision && !jumping) {
							falling = true;
						}
					}
				}
			}
		}

		topCollision = false;

		if (right) {
			GameState.xOffset += moveSpeed;
		}
		if (left) {
			GameState.xOffset -= moveSpeed;
		}
		if (jumping) {
			GameState.yOffset -= currentJumpSpeed;
			currentJumpSpeed -= .1;
			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;

				y_pic = y_pic - 1; //not the best, but its work...
			}
		}
		if (falling) {
			GameState.yOffset += currentFallSpeed;

			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += .1;
			}
		}
		if (!falling) {
			currentFallSpeed = .1;
		}
	}

	public void draw(Graphics g) {
		//g.setColor(new Color(120, 179, 146));
		//g.fillRect((int) x, (int) y, width, height);
		if (!right && !left){
			if (left_animation > right_animation)
				g.drawImage(Images.blocks[10],  x_pic, y_pic, null);
			else
				g.drawImage(Images.blocks[12],  x_pic, y_pic, null);
		}
		if (left) {
			right_animation = 0;
			if (Lframecounter < 100){
				g.drawImage(Images.blocks[10],  x_pic, y_pic, null);
				Lframecounter = Lframecounter + 10;
				System.out.println(Lframecounter);
			}
			else if (Lframecounter < 200){
				g.drawImage(Images.blocks[11],  x_pic, y_pic, null);
				Lframecounter = Lframecounter + 10;
				System.out.println(Lframecounter);
			}
			else if (Lframecounter < 300){
				Lframecounter = 0;
				System.out.println(Lframecounter);
			}
		}

		if (right) {
			left_animation = 0;
			if (Rframecounter < 100){
				g.drawImage(Images.blocks[12],  x_pic, y_pic, null);
				Rframecounter = Rframecounter + 10;
				System.out.println(Rframecounter);
			}
			else if (Rframecounter < 200){
				g.drawImage(Images.blocks[13],  x_pic, y_pic, null);
				Rframecounter = Rframecounter + 10;
				System.out.println(Rframecounter);
			}
			else if (Rframecounter < 300){
				Rframecounter = 0;
				System.out.println(Rframecounter);
			}
		}
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_D){
			right = true;
			right_animation++;
		}
		if (k == KeyEvent.VK_A){
			left = true;
			left_animation++;}
		if (k == KeyEvent.VK_W && !jumping && !falling)
			jumping = true;
		if (k == KeyEvent.VK_ESCAPE)
			System.exit(0);
		if (k == KeyEvent.VK_E && portal) {
			level_counter++;
			portal = false;
			GameStateManager.states.push(new Level2State(gsm));
			}
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_D)
			right = false;
		if (k == KeyEvent.VK_A)
			left = false;
	}
}
