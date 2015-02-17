package tk.thetechnokid.game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.control.EntityController;

public class Enemy extends Creature {

	private static final int SPEED = 6;
	private static BufferedImage enemImg;
	public boolean destroyed;
	
	public ArrayList<Bullet> bullets = new ArrayList<>();

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
		checkPos();
		
		if(Math.abs(EntityController.user.x-x)==5) x = EntityController.user.x;
		if(Math.abs(EntityController.user.y-y)==5) y = EntityController.user.y;
		if(x == EntityController.user.x&&y == EntityController.user.y)
			EntityController.user.wound();
		
		super.move();
	}
	
	public void checkPos() {
		int rand = (int) (Math.random() * 6);
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
		
		if(rand <= 2)
			bullets.add(new Bullet(this,EntityController.user));
	}
}
