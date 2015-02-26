package tk.thetechnokid.game.gfx;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import tk.thetechnokid.game.Game;

public class Map {
	private static final int TILEWIDTH = 32;
	private static final int TILEHEIGHT = 32;

	public static ArrayList<Tile> tiles = new ArrayList<>();
	static Tile[][] tileArr;

	public static void generateTiles() {
		Tile[] all = { Tile.VOID, Tile.GRASS, Tile.WATER1, Tile.WATER2,
				Tile.ROCK, Tile.DIRT, Tile.PORTAL, Tile.TREE };

		tileArr = new Tile[Game.WIDTH / TILEHEIGHT][Game.HEIGHT / TILEWIDTH];

		Random r = new Random();
		for (int x = 0; x < Game.WIDTH / TILEWIDTH; x++) {
			for (int y = 0; y < Game.HEIGHT / TILEHEIGHT; y++) {
				Tile t = all[r.nextInt(all.length)];
				t.x = x * TILEWIDTH;
				t.y = y * TILEHEIGHT;
				tileArr[x][y] = t;
				tiles.add(t);
			}
		}

		System.out.println(tiles.size() + ", " + tileArr.length + ", "
				+ tileArr[0].length);
	}

	public static void render(Graphics g) {
		for (int x = 0; x < Game.WIDTH / TILEWIDTH; x++) {
			for (int y = 0; y < Game.HEIGHT / TILEHEIGHT; y++) {
				tileArr[x][y].render(g);
			}
		}
	}
}
