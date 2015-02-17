package tk.thetechnokid.game.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.control.EntityController;
import tk.thetechnokid.game.control.InputHandler;

public class Player extends Creature {

	private static final int SPEED = 5;
	private static BufferedImage image;
	public ArrayList<Bullet> bullets = new ArrayList<>();
	private boolean shot;

	int enemyLoc = 0;

	private long lastShot;

	static {
		try {
			image = ImageIO.read(new File("res/image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Player() {
		super(100, 100, image);
		health = 20;
	}

	@Override
	public void move() {
		checkInputs();
		checkShots();
		super.move();
	}

	private void checkShots() {
		if (InputHandler.isSpace()) {
			if (shot)
				return;
			try {
				Bullet b = new Bullet(this,
						EntityController.enemies.get(enemyLoc++));
				bullets.add(b);
			} catch (IndexOutOfBoundsException e) {
			}
			lastShot = System.currentTimeMillis();
			shot = true;
		}
		if ((System.currentTimeMillis() - lastShot) > 500)
			shot = false;
	}

	private void checkInputs() {
		xMove = 0;
		yMove = 0;
		
		if (InputHandler.isUp())
			if (y <= 25)
				y = 25;
			else
				yMove = -SPEED;
		if (InputHandler.isDown())
			if (y >= Game.HEIGHT - getImage().getHeight())
				y = Game.HEIGHT - getImage().getHeight();
			else
				yMove = SPEED;
		if (InputHandler.isRight())
			if (x >= Game.WIDTH - getImage().getWidth())
				x = Game.WIDTH - getImage().getWidth();
			else
				xMove = SPEED;
		if (InputHandler.isLeft())
			if (x <= 5)
				x = 5;
			else
				xMove = -SPEED;
	}

}
