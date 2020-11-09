package com.game.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {
	public static BufferedImage[] blocks;

	public Images() {
		blocks = new BufferedImage[10];

		try {
			blocks[0] = ImageIO.read(this.getClass().getResourceAsStream("/res/Blocks/brick_dark.png"));
			blocks[1] = ImageIO.read(this.getClass().getResourceAsStream("/res/Blocks/sky_dark.png"));
			blocks[2] = ImageIO.read(this.getClass().getResourceAsStream("/res/Blocks/portal.png"));
			blocks[3] = ImageIO.read(this.getClass().getResourceAsStream("/res/Blocks/p_frame1.png"));
			blocks[4] = ImageIO.read(this.getClass().getResourceAsStream("/res/Blocks/p_frame2.png"));
			blocks[5] = ImageIO.read(this.getClass().getResourceAsStream("/res/Blocks/p_frame3.png"));
			blocks[6] = ImageIO.read(this.getClass().getResourceAsStream("/res/Blocks/p_frame4.png"));
			blocks[7] = ImageIO.read(this.getClass().getResourceAsStream("/res/Blocks/p_frame5.png"));
			blocks[8] = ImageIO.read(this.getClass().getResourceAsStream("/res/Blocks/p_frame6.png"));
			blocks[9] = ImageIO.read(this.getClass().getResourceAsStream("/res/Blocks/p_frame7.png"));
		} catch (IOException var2) {
			var2.printStackTrace();
		}

	}
}
