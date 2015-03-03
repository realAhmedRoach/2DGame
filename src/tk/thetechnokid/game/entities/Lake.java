package tk.thetechnokid.game.entities;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;

import tk.thetechnokid.game.gfx.Tile;

public class Lake extends Entity {

	private int w, h;
	private HashMap<Point, Tile> tiles = new HashMap<>();

	public Lake(int x, int y, int w, int h) {
		super(x, y,Tile.WATER1.getImage());
		generateTiles();
	}

	private void generateTiles() {
		for (int x = this.x; x < this.x + (w*32); x++) {
			for (int y = this.y; y < this.y + (h*32); y++) {
				boolean water2 = Math.random() <= .5;
				Tile tile = water2 ? Tile.WATER2 : Tile.WATER1;
				System.out.println("x="+x+",y="+y);
				tiles.put(new Point(x*32,y*32), tile);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		for (Point p : tiles.keySet()) {
			Tile t = tiles.get(p);
			g.drawImage(t.getImage(), p.x, p.y, null);
		}
	}

	@Override
	public void tick() {
	}
}
