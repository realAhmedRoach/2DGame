package tk.thetechnokid.game.entities;

import tk.thetechnokid.game.Game;

public class Bullet extends Entity {
	private static final int SPEED = 4;
	private Creature target; // be french fries
	public boolean drawn;
	private int xdir, ydir;

	private long startTime;

	public Bullet(Creature parent, Creature target) {
		super(parent.x, parent.y, Tile.s.crop(3,1,32,32));
		this.target = target;
		startTime = System.currentTimeMillis();
		if(target.x == x && target.y == y) destroyed  = true;
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
		boolean atTarget = Math.abs(target.x - x) <= 2 && Math.abs(target.y - y) <= 2;
		if (atTarget&&!destroyed) {
			target.destroyed = true;
			destroyed = true;
			Game.KILLS++;
		}
	}

}
