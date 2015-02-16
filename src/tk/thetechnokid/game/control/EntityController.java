package tk.thetechnokid.game.control;

import java.awt.Graphics;
import java.util.ArrayList;

import tk.thetechnokid.game.entities.Bullet;
import tk.thetechnokid.game.entities.Enemy;
import tk.thetechnokid.game.entities.Entity;
import tk.thetechnokid.game.entities.Player;
import tk.thetechnokid.game.entities.Wall;

public class EntityController {
	public static ArrayList<Entity> entities;
	public static ArrayList<Enemy> enemies;
	public static ArrayList<Wall> walls;

	public static Player user;
	static {
		entities = new ArrayList<>();
		enemies = new ArrayList<>();
		walls = new ArrayList<>();
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
		for (Bullet b : user.bullets) {
			if (b.drawn) b = null;
		}
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).destroyed) {
				enemies.remove(i);
				System.out.println("SWAG");
			}
		}
	}

	public static void render(Graphics g) {
		for (Entity entity : entities) {
			entity.move();
			entity.render(g);
			if (entity instanceof Player) {
				Player p = (Player) entity;
				for (Bullet b : p.bullets) {
					b.move();
					b.render(g);
				}
			}
		}

	}
}
