package tk.thetechnokid.game.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.Main;
import tk.thetechnokid.game.control.EntityController;
import tk.thetechnokid.game.control.InputHandler;

public class Player extends Entity {

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

	public Player(int x, int y) {
		super(x, y, image);
	}

	@Override
	public void move() {
		if (InputHandler.isUp()) if (y <= 25) y = 25;
		else y -= SPEED;
		if (InputHandler.isDown())
			if (y >= Main.HEIGHT - getImage().getHeight()) y = Main.HEIGHT
					- getImage().getHeight();
			else y += SPEED;
		if (InputHandler.isRight())
			if (x >= Main.WIDTH - getImage().getWidth()) x = Main.WIDTH
					- getImage().getWidth();
			else x += SPEED;
		if (InputHandler.isLeft()) if (x <= 5) x = 5;
		else x -= SPEED;
		if (InputHandler.isSpace()) {
			if (shot) return;
			try {
				Bullet b = new Bullet(this,
						EntityController.enemies.get(enemyLoc++));
				bullets.add(b);
			} catch (IndexOutOfBoundsException e) {
			}
			lastShot = System.currentTimeMillis();
			shot = true;
		}
		if ((System.currentTimeMillis() - lastShot) > 500) shot = false;
	}

}
