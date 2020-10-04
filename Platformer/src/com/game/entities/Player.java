package com.game.entities;

import com.game.gamestate.GameState;
import com.game.main.GamePanel;
import com.game.objects.Block;
import com.game.physics.Collison;

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

	private boolean topCollision = false;
	private double moveSpeed = 2.5;

	public Player(int width, int height) {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}

	public void tick(Block[][] b) {

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j].getID() != 0) {
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
		g.setColor(new Color(120, 179, 146));
		g.fillRect((int) x, (int) y, width, height);
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_D)
			right = true;
		if (k == KeyEvent.VK_A)
			left = true;
		if (k == KeyEvent.VK_W && !jumping && !falling)
			jumping = true;
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_D)
			right = false;
		if (k == KeyEvent.VK_A)
			left = false;
	}
}
