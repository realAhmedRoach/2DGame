package tk.thetechnokid.game.entities.mapobjects;

import java.awt.Point;

import tk.thetechnokid.game.entities.Tile;

public class Grassland extends MapObject {

	public Grassland(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	protected void generateTiles() {
		for (int x = this.x; x < this.x + w; x++) {
			for (int y = this.y; y < this.y + h; y++) {
				boolean rock = Math.random() <= .2;
				Tile tile = rock ? Tile.ROCK : Tile.GRASS;
				tiles.put(new Point(x*32,y*32), tile);
			}
		}
	}

	@Override
	public void tick() {
	}

}
