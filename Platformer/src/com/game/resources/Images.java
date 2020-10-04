package com.game.resources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {

	public static BufferedImage[] blocks;
	public static BufferedImage[] sky;
	
	public Images() {
		blocks = new BufferedImage[1];
		try {
			blocks[0] = ImageIO.read(getClass().getResourceAsStream("res/Blocks/pixelbrick.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
