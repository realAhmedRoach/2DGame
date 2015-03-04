package tk.thetechnokid.game.gfx;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Random;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.entities.mapobjects.Forest;
import tk.thetechnokid.game.entities.mapobjects.MapObject;

public class Map {
	private static final int TILESIZE = 32;
	static boolean lake;

	private static HashMap<Point, Tile> tiles = new HashMap<>();
	private static HashMap<Point, MapObject> objects = new HashMap<>();

	public static void generateTiles() {
		tiles.clear();
		Tile[] allNormTiles = { Tile.GRASS, Tile.ROCK, Tile.DIRT, Tile.TREE };

		Random r = new Random();
		for (int x = 0; x < Game.WIDTH / TILESIZE; x++) {
			for (int y = 0; y < Game.HEIGHT / TILESIZE; y++) {
				Point p = new Point(x * TILESIZE, y * TILESIZE);
				Tile tile = allNormTiles[r.nextInt(allNormTiles.length)];
				tiles.put(p, tile);


				if (!lake) {
					Forest l = new Forest(r.nextInt(Game.WIDTH / TILESIZE), r.nextInt(Game.HEIGHT / TILESIZE), 5, 5);
					objects.put(p, l);
					lake = true;
				}
			}
		}
	}

	public static void render(Graphics g) {
//		for (Point p : tiles.keySet()) {
//			g.drawImage(tiles.get(p).getImage(), p.x, p.y, null);
//		}
		for (Point p : objects.keySet()) {
			objects.get(p).render(g);
		}
	}
}
