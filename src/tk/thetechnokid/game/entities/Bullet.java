package tk.thetechnokid.game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends Entity {
	private static BufferedImage image;
	private static final int SPEED = 3;
	private Creature target; // be french fries
	public boolean drawn;
	private int xdir, ydir;

	private long startTime;

	static {
		try {
			image = ImageIO.read(new File("res/bullet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Bullet(Creature parent, Creature target) {
		super(parent.x, parent.y, image);
		this.target = target;
		startTime = System.currentTimeMillis();
		if(target.x == x && target.y == y) destroyed  = true;
	}

	public void render(Graphics g) {
		super.render(g);
	}

	@Override
	public void tick() {
		if((System.currentTimeMillis()-startTime)>1000) {
			destroyed = true;
			return;
		}
		if (target.y > y) ydir = 1;
		if (target.y < y) ydir = -1;
		if (target.y == y) ydir = 0;
		if (target.x > x) xdir = 1;
		if (target.x < x) xdir = -1;
		if (target.x == x) xdir = 0;
		y += SPEED * ydir;
		x += SPEED * xdir;
		if (Math.abs(target.x - x) <= 2 && Math.abs(target.y - y) <= 2) {
			target.destroyed = true;
			destroyed = true;
		}
	}

}
