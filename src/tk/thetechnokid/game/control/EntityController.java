package tk.thetechnokid.game.control;

import java.awt.Graphics;
import java.util.ArrayList;

import tk.thetechnokid.game.entities.Bullet;
import tk.thetechnokid.game.entities.Enemy;
import tk.thetechnokid.game.entities.Entity;
import tk.thetechnokid.game.entities.Player;

public class EntityController {
	public static ArrayList<Entity> entities;
	
	public static Player user;
	public static Enemy enemy;
	static {
		entities = new ArrayList<>();
	}
	public static void setUser(Player u) {
		user = u;
		addEntity(user);
	}
	
	public static void setEnemy(Enemy m) {
		enemy = m;
		addEntity(enemy);
	}
	
	public static void addEntity(Entity e) {
		entities.add(e);
	}
	
	public static void tick() {
		for(Bullet b : user.bullets) {
			if(b.drawn) b = null;
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
