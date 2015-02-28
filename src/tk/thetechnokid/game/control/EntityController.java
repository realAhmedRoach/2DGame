package tk.thetechnokid.game.control;

import java.awt.Graphics;
import java.util.concurrent.CopyOnWriteArrayList;

import tk.thetechnokid.game.entities.*;

public class EntityController {
	public static CopyOnWriteArrayList<Entity> entities;
	public static CopyOnWriteArrayList<Enemy> enemies;
	public static CopyOnWriteArrayList<Wall> walls;
	public static CopyOnWriteArrayList<Bullet> bullets;

	public static Player user;
	static {
		entities = new CopyOnWriteArrayList<>();
		enemies = new CopyOnWriteArrayList<>();
		walls = new CopyOnWriteArrayList<>();
		bullets = new CopyOnWriteArrayList<>();
	}

	public static void setUser(Player u) {
		user = u;
		addEntity(user);
	}

	public static void addEnemy(Enemy enemy) {
		enemies.add(enemy);
		addEntity(enemy);
	}

	public static void addWall(Wall w) {
		walls.add(w);
		addEntity(w);
	}

	public static void addEntity(Entity e) {
		entities.add(e);
	}

	public static void removeEntity(Entity e) {
		entities.remove(e);
		if (e instanceof Enemy) {
			Enemy en = (Enemy) e;
			enemies.remove(en);
		} else if (e instanceof Wall) {
			Wall w = (Wall) e;
			walls.remove(w);
		}
	}

	public static void tick() {
		for (Entity e : entities) {
			if (e.destroyed) {
				removeEntity(e);
			}
		} for (Bullet b : bullets) {
			if (b.destroyed) {
				bullets.remove(b);
			}
		}
	}

	public static void render(Graphics g) {
		for (Entity entity : entities) {
			entity.tick();
			entity.render(g);
		}
		for (Bullet b: bullets) {
			b.tick();
			b.render(g);
		}
	}
}
