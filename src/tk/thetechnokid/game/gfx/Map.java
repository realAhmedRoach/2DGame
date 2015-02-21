package tk.thetechnokid.game.gfx;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import tk.thetechnokid.game.Game;

public class Map {
	private static final int TILEWIDTH = 32;
	private static final int TILEHEIGHT = 32;

	public static ArrayList<Tile> tiles = new ArrayList<>();

	public static void generateTiles() {
		Tile[] all = { Tile.VOID, Tile.GRASS, Tile.WATER1, Tile.WATER2,
				Tile.ROCK, Tile.DIRT, Tile.PORTAL, Tile.TREE };

		Random r = new Random();
		for (int y = 0; y < Game.HEIGHT / TILEWIDTH; y ++) {
			for (int x = 0; x < Game.WIDTH / TILEHEIGHT; x ++) {
				Tile t = all[r.nextInt(all.length)];
				t.x = x * TILEWIDTH;
				t.y = y * TILEHEIGHT;
				System.out.println(t.x + ", " + t.y);
				tiles.add(t);
			}
		}

		System.out.println(tiles.size());
	}

	public static void render(Graphics g) {
		for (Tile tile : tiles) {
			g.drawImage(tile.getImage(), tile.x, tile.y, null);
		}
	}
}
