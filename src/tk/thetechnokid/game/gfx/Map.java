package tk.thetechnokid.game.gfx;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import tk.thetechnokid.game.Game;

public class Map {
	public static ArrayList<Tile> tiles = new ArrayList<>();

	private static int COLS = Game.WIDTH;
	private static int ROWS = Game.HEIGHT;

	public static void generateTiles() {
		Tile[] all = { Tile.VOID, Tile.GRASS, Tile.WATER1, Tile.WATER2,
				Tile.ROCK, Tile.DIRT, Tile.PORTAL };

		System.out.println(COLS);
		System.out.println(ROWS);
		
		Random r = new Random();
		for (int y = 26; y < COLS; y+=32) {
			for (int x = 0; x < ROWS; x+=32) {
				int rand = r.nextInt(all.length);
				Tile t = all[rand];
				t.x = x;
				t.y = y;
				tiles.add(t);
			}
		}
	}

	public static void render(Graphics g) {
		for (Tile tile : tiles) {
			g.drawImage(tile.getImage(), tile.x, tile.y, null);
		}
	}
}
