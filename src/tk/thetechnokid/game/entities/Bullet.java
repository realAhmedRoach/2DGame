package tk.thetechnokid.game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends Entity {
	private static BufferedImage image;
	private static final int SPEED = 2;
	private boolean drawn;
	private int xdir,ydir;
	
	static {
		try {
			image = ImageIO.read(new File("res/bullet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public Bullet(Player parent,Entity target) {
		super(parent.x, parent.y, image);
		xdir = 0;
		ydir = -1;
	}

	public void render(Graphics g) {
		if(!drawn) super.render(g);
		if(y == 0) drawn = true;
	}
	
	@Override
	public void move() {
		y+=SPEED*ydir;
		x+=SPEED*xdir;
	}

}
