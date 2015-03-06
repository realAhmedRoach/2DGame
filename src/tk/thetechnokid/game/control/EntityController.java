package tk.thetechnokid.game.control;

import java.awt.Graphics;
import java.util.concurrent.CopyOnWriteArrayList;

import tk.thetechnokid.game.entities.*;

public class EntityController {
	public static CopyOnWriteArrayList<Entity> entities;
	public static CopyOnWriteArrayList<Enemy> enemies;
	public static CopyOnWriteArrayList<Bullet> bullets;

	public static Player user;
	static {
		entities = new CopyOnWriteArrayList<>();
		enemies = new CopyOnWriteArrayList<>();
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

	public static void addEntity(Entity e) {
		entities.add(e);
	}

	public static void removeEntity(Entity e) {
		entities.remove(e);
		if (e instanceof Enemy) {
			Enemy en = (Enemy) e;
			enemies.remove(en);
		}
	}

	public static void tick() {
		for (Entity e : entities) {
			if (e.destroyed) {
				removeEntity(e);
			}
			e.tick();
		} for (Bullet b : bullets) {
			if (b.destroyed) {
				bullets.remove(b);
			}
			b.tick();
		}
	}

	public static void render(Graphics g) {
		for (Entity entity : entities) {
			entity.render(g);
		}
		for (Bullet b: bullets) {
			b.render(g);
		}
	}
}
