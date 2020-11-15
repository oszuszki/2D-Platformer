package com.game.entities;

import com.game.gamestate.game.GameState;
import com.game.gamestate.game.GameStateManager;
import com.game.gamestate.levels.Level1State;
import com.game.main.GamePanel;
import com.game.objects.Block;
import com.game.objects.MovingBlocks;
import com.game.physics.Collison;
import com.game.resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player {

	private boolean right = false, left = false, jumping = false, falling = false;

	private double x, y;
	private int width, height;

	private double jumpSpeed = 5;
	private double currentJumpSpeed = jumpSpeed;

	public static int level_counter = 1;

	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;

	private boolean topCollision = false;
	private double moveSpeed = 2.5;

	private int x_pic = 170;
	private int y_pic = 183;
	private int left_animation, right_animation;
	private int Lframecounter, Rframecounter;
	private static int death_counter;

	private GameStateManager gsm;

	private String pName;

	public Player(int width, int height) {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}

	public void tick(Block[][] b, ArrayList<MovingBlocks> movingBlocks) { //portal
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j].getID() == 2) {
					// right
					if (Collison
							.playerBlock(new Point((int) x + width + (int) GameState.xOffset,
									(int) y + (int) GameState.yOffset + 2), b[i][j])
							|| Collison.playerBlock(new Point((int) x + width + (int) GameState.xOffset,
							(int) y + height + (int) GameState.yOffset - 1), b[i][j])) {
						level_counter++;
						GameStateManager.states.push(new Level1State(gsm,pName));
				}}}}

		for (int i = 0; i < b.length; i++) {  //trap
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j].getID() == 4) {
					// right
					if (Collison
							.playerBlock(new Point((int) x + width + (int) GameState.xOffset,
									(int) y + (int) GameState.yOffset + 2), b[i][j])
							|| Collison.playerBlock(new Point((int) x + width + (int) GameState.xOffset,
							(int) y + height + (int) GameState.yOffset - 1), b[i][j])) {
						death_counter = death_counter + 1;
						GameStateManager.states.push(new Level1State(gsm,pName));
					}
					// left
					if (Collison
							.playerBlock(new Point((int) x + (int) GameState.xOffset - 1,
									(int) y + (int) GameState.yOffset + 2), b[i][j])
							|| Collison.playerBlock(new Point((int) x + (int) GameState.xOffset - 2,
							(int) y + height + (int) GameState.yOffset - 1), b[i][j])) {
						death_counter = death_counter + 1;
						GameStateManager.states.push(new Level1State(gsm,pName));
					}
					// bottom
					if (Collison
							.playerBlock(new Point((int) x + (int) GameState.xOffset + 2,
									(int) y + height + (int) GameState.yOffset + 1), b[i][j])
							|| Collison.playerBlock(new Point((int) x + width + (int) GameState.xOffset - 2,
							(int) y + height + (int) GameState.yOffset + 1), b[i][j])) {
						death_counter = death_counter + 1;
						y = b[i][j].getY() - height - GameState.yOffset;
						GameStateManager.states.push(new Level1State(gsm,pName));
					}
				}
			}
		}



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

		for(int i = 0; i < movingBlocks.size(); i++)
		{
			if(movingBlocks.get(i).getID() != 0)
			{
				if (movingBlocks.get(i).getID() == 1) {
					// right
					if (Collison
							.playerMovingBlock(new Point((int) x + width + (int) GameState.xOffset,
									(int) y + (int) GameState.yOffset + 2), movingBlocks.get(i))
							|| Collison.playerMovingBlock(new Point((int) x + width + (int) GameState.xOffset,
							(int) y + height + (int) GameState.yOffset - 1), movingBlocks.get(i))) {
						right = false;
					}
					// left
					if (Collison
							.playerMovingBlock(new Point((int) x + (int) GameState.xOffset - 1,
									(int) y + (int) GameState.yOffset + 2), movingBlocks.get(i))
							|| Collison.playerMovingBlock(new Point((int) x + (int) GameState.xOffset - 2,
							(int) y + height + (int) GameState.yOffset - 1), movingBlocks.get(i))) {
						left = false;
					}
					// top
					if (Collison.playerMovingBlock(
							new Point((int) x + (int) GameState.xOffset + 2, (int) y + (int) GameState.yOffset),
							movingBlocks.get(i))
							|| Collison.playerMovingBlock(new Point((int) x + width + (int) GameState.xOffset - 2,
							(int) y + (int) GameState.yOffset), movingBlocks.get(i))) {
						jumping = false;
						falling = true;
					}
					// bottom
					if (Collison
							.playerMovingBlock(new Point((int) x + (int) GameState.xOffset + 2,
									(int) y + height + (int) GameState.yOffset + 1), movingBlocks.get(i))
							|| Collison.playerMovingBlock(new Point((int) x + width + (int) GameState.xOffset - 2,
							(int) y + height + (int) GameState.yOffset + 1), movingBlocks.get(i))) {
						y = movingBlocks.get(i).getY() - height - GameState.yOffset;
						falling = false;
						topCollision = true;

						GameState.xOffset += movingBlocks.get(i).getMove();

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

		g.setColor(new Color(216, 67, 21));
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Name: " + pName, 15, 20);

		g.setColor(new Color(216, 67, 21));
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Deaths: " + death_counter, 15, 40);

		g.setColor(new Color(216, 67, 21));
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Level: " + level_counter, 15, 60);

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
			}
			else if (Lframecounter < 200){
				g.drawImage(Images.blocks[11],  x_pic, y_pic, null);
				Lframecounter = Lframecounter + 10;
			}
			else if (Lframecounter < 300)
				Lframecounter = 0;
		}

		if (right) {
			left_animation = 0;
			if (Rframecounter < 100){
				g.drawImage(Images.blocks[12],  x_pic, y_pic, null);
				Rframecounter = Rframecounter + 10;
			}
			else if (Rframecounter < 200){
				g.drawImage(Images.blocks[13],  x_pic, y_pic, null);
				Rframecounter = Rframecounter + 10;
			}
			else if (Rframecounter < 300)
				Rframecounter = 0;
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
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_D)
			right = false;
		if (k == KeyEvent.VK_A)
			left = false;
	}


	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
}
