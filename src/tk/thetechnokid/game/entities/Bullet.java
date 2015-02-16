package tk.thetechnokid.game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends Entity {
	private static BufferedImage image;
	private static final int SPEED = 3;
	private Entity target;
	public boolean drawn;
	private int xdir, ydir;

	static {
		try {
			image = ImageIO.read(new File("res/bullet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Bullet(Entity parent, Entity target) {
		super(parent.x, parent.y, image);
		this.target = target;
		if(target.x == x && target.y == y) drawn  = true;
	}

	public void render(Graphics g) {
		if (!drawn) super.render(g);
		if (y == 0) drawn = true;
	}

	@Override
	public void move() {
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
			drawn = true;
		}
	}

}
