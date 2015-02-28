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
		for (int x = 0; x < Game.WIDTH / TILEWIDTH; x++) {
			for (int y = 0; y < Game.HEIGHT / TILEHEIGHT; y++) {
				Tile t = all[r.nextInt(all.length)];
				t.x = x * TILEWIDTH;
				t.y = y * TILEHEIGHT;
				Tile.TILES.add(t);
			}
		}
	}

	public static void render(Graphics g) {
		for (Tile t : Tile.TILES){
			t.render(g);
		}
	}
}
