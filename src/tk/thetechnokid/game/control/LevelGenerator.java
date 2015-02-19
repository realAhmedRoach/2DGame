package tk.thetechnokid.game.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.entities.Enemy;
import tk.thetechnokid.game.entities.Wall;

public class LevelGenerator {
	public static void generateRandomLevel() {
		EntityController.entities.clear();
		EntityController.enemies.clear();
		EntityController.walls.clear();
		
		int rand = (int) (Math.random()*6);
		ArrayList<Wall> walls = new ArrayList<>();
		ArrayList<Enemy> enemies = new ArrayList<>();
		Random r = new Random();
		
		for(int i = 0; i<rand;i++) {
			int x = r.nextInt(Game.WIDTH);
			int y = r.nextInt(Game.HEIGHT);
			Wall wall = new Wall(x,y);
			Wall wall2 = new Wall(x,y+100);
			walls.add(wall);
			walls.add(wall2);
		} for (int i = 0; i<r.nextInt(6); i++) {
			int x = r.nextInt(Game.WIDTH);
			int y = r.nextInt(Game.HEIGHT);
			Enemy enemy = new Enemy(x,y);
			Enemy enemy2 = new Enemy(x,y+100);
			enemies.add(enemy);
			enemies.add(enemy2);
		}
		
		EntityController.enemies.addAll(enemies);
		EntityController.walls.addAll(walls);
		EntityController.entities.addAll(enemies);
		EntityController.entities.addAll(walls);
	}

	public static void generateFromFile(String path) {
		EntityController.entities.clear();
		EntityController.enemies.clear();
		EntityController.walls.clear();

		ArrayList<Wall> walls = new ArrayList<>();
		ArrayList<Enemy> enemies = new ArrayList<>();
		
		try {
			BufferedReader r = new BufferedReader(new FileReader(new File(path)));
			String line;
			while((line = r.readLine())!= null) {
				String[] curr = line.split(" ");
				if (curr[0].equals("e")) {
					Enemy e = new Enemy(Integer.parseInt(curr[1]),Integer.parseInt(curr[2]));
					enemies.add(e);
				} else if(curr[0].equals("w")) {
					Wall w = new Wall(Integer.parseInt(curr[1]),Integer.parseInt(curr[2]));
					walls.add(w);
				}
			}
			r.close();
		} catch(Exception e) {
			generateRandomLevel();
			e.printStackTrace();
		}
		
		EntityController.enemies.addAll(enemies);
		EntityController.walls.addAll(walls);
		EntityController.entities.addAll(enemies);
		EntityController.entities.addAll(walls);
	}
}
