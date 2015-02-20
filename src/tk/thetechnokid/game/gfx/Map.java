package tk.thetechnokid.game.gfx;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import tk.thetechnokid.game.Game;

public class Map {
	public static ArrayList<Tile> tiles = new ArrayList<>();

	public static void generateTiles() {
		Tile[] all = { Tile.VOID, Tile.GRASS, Tile.WATER1, Tile.WATER2,
				Tile.ROCK, Tile.DIRT, Tile.PORTAL };
		
		Random r = new Random();
		for(int y=32;y<Game.WIDTH/32;y+=32) {
			for(int x=32;x<Game.HEIGHT/32;x+=32) {
				int rand = r.nextInt(all.length-1);
				Tile t = all[rand];
				t.x=x;
				t.y=y;
				tiles.add(t);
			}
		}
	}
	
	public static void render(Graphics g) {
		for (Tile tile : tiles) {
			tile.render(g);
		}
	}
}
