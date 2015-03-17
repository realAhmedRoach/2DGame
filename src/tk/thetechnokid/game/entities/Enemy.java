package tk.thetechnokid.game.entities;

import java.util.ArrayList;

import tk.thetechnokid.game.control.EntityController;

public class Enemy extends Creature {

	private static final int SPEED = 3;

	boolean diffX;
	boolean diffY;

	public final boolean isBoss;

	public ArrayList<Bullet> bullets = new ArrayList<>();

	public Enemy(int x, int y) {
		super(x, y, Tile.s.crop(1, 1));
		isBoss = Math.random()<.3;
		if(isBoss) {
			width = 64;
			height = 64;
		}
	}

	@Override
	public void tick() {
		checkPos();

		diffX = Math.abs(EntityController.user.x - x) <= 5;
		diffY = Math.abs(EntityController.user.y - y) <= 5;
		if (diffY && diffX)
			EntityController.user.wound();

		super.tick();
	}

	public void wound() {
		if(isBoss) {
			health /= 2;
		} else {
			health = 0;
			destroyed = true;
		}
	}

	public void checkPos() {
		if (EntityController.user.x > x) xMove = SPEED;
		if (EntityController.user.x < x) xMove = -SPEED;
		if (EntityController.user.y > y) {
			sprite = Tile.s.crop(1, 1);
			yMove = SPEED;
		}
		if (EntityController.user.y < y){
			sprite = Tile.s.crop(1, 2);
			yMove = -SPEED;
		}
		if(diffX) xMove = 0;
		if(diffY) yMove = 0;
	}
}
