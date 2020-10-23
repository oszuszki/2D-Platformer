package com.game.resources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public static BufferedImage[] blocks;
	
	public Images() {
		blocks = new BufferedImage[3];
		try {
			blocks[0] = ImageIO.read(getClass().getResourceAsStream("/res/Blocks/pixelbrick.png"));
			blocks[1] = ImageIO.read(getClass().getResourceAsStream("/res/Blocks/sky.png"));
			blocks[2] = ImageIO.read(getClass().getResourceAsStream("/res/Blocks/portal.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}