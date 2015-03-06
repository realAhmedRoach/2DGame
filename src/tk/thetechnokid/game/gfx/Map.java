package tk.thetechnokid.game.gfx;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Random;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.entities.mapobjects.*;

public class Map {
	private static final int TILESIZE = 32;
	static boolean lake;
	private static HashMap<Point, MapObject> objects = new HashMap<>();

	public static void generateTiles() {
		Random r = new Random();
		for (int x = 0; x < Game.WIDTH / TILESIZE; x++) {
			for (int y = 0; y < Game.HEIGHT / TILESIZE; y++) {
				Point p = new Point(x * TILESIZE, y * TILESIZE);
				if (x * TILESIZE % 5 == 0 && y * TILESIZE % 5 == 0) {
					int type = r.nextInt(3);
					MapObject l = null;
					switch(type){
					case 0:
						l = new Grassland(x, y, 5, 5);
						break;
					case 1:
						l = new Forest(x, y, 5, 5);
						break;
					case 2:
						l = new Lake(x, y, 5, 5);
						break;
					}
					objects.put(p, l);
					lake = true;
				}
			}
		}
	}

	public static void render(Graphics g) {
		for (Point p : objects.keySet()) {
			objects.get(p).render(g);
		}
	}
}
