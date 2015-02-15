package tk.thetechnokid.game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.control.EntityController;

public class Enemy extends Entity {

	private static final int SPEED = 6;
	private static BufferedImage enemImg;

	static {
		try {
			enemImg = ImageIO.read(new File("res/enemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Enemy(int x, int y) {
		super(x, y, enemImg);
	}

	public void render(Graphics g) {
		super.render(g);
	}

	@Override
	public void move() {
		int rand = (int) (Math.random() * 5);
		if (rand <= 2)
			return;
		if (EntityController.user.x > x) 
			x += SPEED;
		if (EntityController.user.x < x) 
			x -= SPEED;
		if (EntityController.user.y > y) 
			y += SPEED;
		if (EntityController.user.y < y) 
			y -= SPEED;
		if(Math.abs(EntityController.user.x-x)==5) x = EntityController.user.x;
		if(Math.abs(EntityController.user.y-y)==5) y = EntityController.user.y;
	}
}
