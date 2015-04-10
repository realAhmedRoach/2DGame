package tk.thetechnokid.game.control;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.entities.Enemy;
import tk.thetechnokid.game.entities.Player;

public class LevelGenerator {
	public static void generateRandomLevel() {
		EntityController.entities.clear();
		EntityController.enemies.clear();

		ArrayList<Enemy> enemies = new ArrayList<>();

		Random r = new Random();
		for (int i = 0; i < r.nextInt(5) + Game.LEVEL; i++) {
			int x = r.nextInt(Game.WIDTH);
			int y = r.nextInt(Game.HEIGHT);
			Enemy enemy = new Enemy(x, y);
			enemies.add(enemy);
		}

		EntityController.enemies.addAll(enemies);
		EntityController.entities.addAll(enemies);

		if(EntityController.user == null || EntityController.user.destroyed) {
			EntityController.setUser(new Player());
		}
	}

	public static void generateFromFile(String path) {
		EntityController.entities.clear();
		EntityController.enemies.clear();

		ArrayList<Enemy> enemies = new ArrayList<>();

		try {
			BufferedReader r = new BufferedReader(new FileReader(new File(path)));
			String line;
			while ((line = r.readLine()) != null) {
				String[] curr = line.split(" ");
				if (curr[0].equals("e")) {
					Enemy e = new Enemy(Integer.parseInt(curr[1]), Integer.parseInt(curr[2]));
					enemies.add(e);
				}
			}
			r.close();
		} catch (Exception e) {
			generateRandomLevel();
			e.printStackTrace();
		}

		EntityController.enemies.addAll(enemies);
		EntityController.entities.addAll(enemies);
	}
}
