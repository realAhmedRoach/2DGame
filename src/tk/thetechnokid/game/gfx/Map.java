package tk.thetechnokid.game.gfx;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Random;

import tk.thetechnokid.game.Game;

public class Map {
	private static final int TILESIZE = 32;

	private static HashMap<Point, Tile> tiles = new HashMap<>();

	public static void generateTiles() {
		tiles.clear();
		Tile[] allNormTiles = { Tile.GRASS, Tile.ROCK, Tile.DIRT, Tile.TREE };

		Random r = new Random();
		for (int x = 0; x < Game.WIDTH / TILESIZE; x++) {
			for (int y = 0; y < Game.HEIGHT / TILESIZE; y++) {
				Tile tile = allNormTiles[r.nextInt(allNormTiles.length)];
				tiles.put(new Point(x * TILESIZE, y * TILESIZE), tile);
			}
		}
	}

	public static void render(Graphics g) {
		for (Point p : tiles.keySet()) {
			g.drawImage(tiles.get(p).getImage(), p.x, p.y, null);
		}
	}
}
