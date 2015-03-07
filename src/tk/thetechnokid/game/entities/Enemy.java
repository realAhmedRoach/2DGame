package tk.thetechnokid.game.entities;

import java.util.ArrayList;

import tk.thetechnokid.game.control.EntityController;
import tk.thetechnokid.game.gfx.Tile;

public class Enemy extends Creature {

	private static final int SPEED = 3;

	boolean diffX;
	boolean diffY;

	public ArrayList<Bullet> bullets = new ArrayList<>();

	public Enemy(int x, int y) {
		super(x, y, Tile.s.crop(1, Math.random()<.5?1:2, 32, 32));
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

	public void checkPos() {
		int rand = (int) (Math.random() * 6);
		if (rand <= 2) return;
		if (EntityController.user.x > x && !diffX) xMove = SPEED;
		if (EntityController.user.x < x && !diffX) xMove = -SPEED;
		if (EntityController.user.y > y && !diffY) yMove = SPEED;
		if (EntityController.user.y < y && !diffY) yMove = -SPEED;
		if(diffX) xMove = 0;
		if(diffY) yMove = 0;
	}
}
