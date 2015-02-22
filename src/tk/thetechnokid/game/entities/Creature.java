package tk.thetechnokid.game.entities;

import java.awt.image.BufferedImage;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	
	protected int health;
	protected int xMove, yMove;
	
	public Creature(int x, int y, BufferedImage image) {
		super(x, y, image);
		health = DEFAULT_HEALTH;
	}

	protected void checkHealth() {
		if(health == 0) destroyed = true;
	}
	
	public void wound() {
		health--;
	}
	
	@Override
	public void tick() {
		checkHealth();
		move();
	}
	
	public void move() {
		x+=xMove;
		y+=yMove;
	}

}
