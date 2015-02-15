package tk.thetechnokid.game.control;

import java.util.ArrayList;

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
}
