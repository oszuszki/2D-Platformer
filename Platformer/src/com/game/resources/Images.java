package com.game.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {
	public static BufferedImage[] blocks;

	public Images() {
		blocks = new BufferedImage[15];

		try {
			blocks[0] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/brick_dark.png"));
			blocks[1] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/sky_dark.png"));
			blocks[2] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/portal.png"));
			blocks[3] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/p_frame1.png"));
			blocks[4] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/p_frame2.png"));
			blocks[5] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/p_frame3.png"));
			blocks[6] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/p_frame4.png"));
			blocks[7] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/p_frame5.png"));
			blocks[8] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/p_frame6.png"));
			blocks[9] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/p_frame7.png"));
			blocks[10] = ImageIO.read(this.getClass().getResourceAsStream("/res/player/player_L.png")); //player
			blocks[11] = ImageIO.read(this.getClass().getResourceAsStream("/res/player/player_L1.png")); //player
			blocks[12] = ImageIO.read(this.getClass().getResourceAsStream("/res/player/player_R.png")); //player
			blocks[13] = ImageIO.read(this.getClass().getResourceAsStream("/res/player/player_R1.png")); //player
			blocks[14] = ImageIO.read(this.getClass().getResourceAsStream("/res/blocks/trap2.png")); //trap block
		} catch (IOException var2) {
			var2.printStackTrace();
		}

	}
}
