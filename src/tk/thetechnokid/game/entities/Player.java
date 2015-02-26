package tk.thetechnokid.game.entities;

import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.control.EntityController;
import tk.thetechnokid.game.control.InputHandler;
import tk.thetechnokid.game.gfx.Tile;

public class Player extends Creature {

	private static final int SPEED = 3;
	private static BufferedImage image;
	public CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<>();
	private boolean shot;

	int enemyLoc = 0;

	private long lastShot;

	static {
		image = Tile.s.crop(0, 1, 32, 32);
	}

	public Player() {
		super((int) (Math.random() * 101), (int) (Math.random() * 101), image);
		health = 20;
	}

	@Override
	public void tick() {
		checkInputs();
		checkShots();
		super.tick();
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

		if (InputHandler.isUp()) {
			sprite = Tile.s.crop(0,2,32,32);
			if (y <= 25)
				y = 25;
			else
				yMove = -SPEED;
		} if (InputHandler.isDown()) {
			sprite = Tile.s.crop(0,1,32,32);
			if (y >= Game.HEIGHT - getImage().getHeight())
				y = Game.HEIGHT - getImage().getHeight();
			else
				yMove = SPEED;
		} if (InputHandler.isRight()) {
			sprite = Tile.s.crop(0,3,32,32);
			if (x >= Game.WIDTH - getImage().getWidth())
				x = Game.WIDTH - getImage().getWidth();
			else
				xMove = SPEED;
		} if (InputHandler.isLeft()) {
			sprite = Tile.s.crop(0,4,32,32);
			if (x <= 2)
				x = 2;
			else
				xMove = -SPEED;
		}
	}

	public void removeBullet(Bullet crap) {
		EntityController.user.bullets.remove(crap);
	}

}
