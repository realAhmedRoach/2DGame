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
			walls.remove(e);
		}
	}

	public static void tick() {
		for (Bullet b : user.bullets) {
			if (b.destroyed) user.removeBullet(b);
		}
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).destroyed) {
				entities.remove(i);
			}
		}
	}

	public static void render(Graphics g) {
		for (Entity entity : entities) {
			entity.tick();
			entity.render(g);
			if (entity instanceof Player) {
				Player p = (Player) entity;
				for (Bullet b : p.bullets) {
					b.tick();
					b.render(g);
				}
			}
		}

	}
}
