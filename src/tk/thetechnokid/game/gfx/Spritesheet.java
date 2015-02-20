package tk.thetechnokid.game.gfx;

import java.awt.image.BufferedImage;

public class Spritesheet {
	private BufferedImage image;
	
	public Spritesheet (BufferedImage i) {
		image = i;
	}
	
	public BufferedImage crop(int col,int row,int w,int h) {
		return image.getSubimage(col*32, row*32, w, h);
	}
}
