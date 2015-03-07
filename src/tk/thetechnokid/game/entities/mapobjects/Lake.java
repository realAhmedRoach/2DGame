package tk.thetechnokid.game.entities.mapobjects;

import java.awt.Point;

import tk.thetechnokid.game.entities.Tile;

public class Lake extends MapObject {

	public Lake(int x, int y, int w, int h) {
		super(x, y,w,h);
	}

	protected void generateTiles() {
		for (int x = this.x; x < this.x + w; x++) {
			for (int y = this.y; y < this.y + h; y++) {
				boolean water2 = Math.random() <= .5;
				Tile tile = water2 ? Tile.WATER2 : Tile.WATER1;
				tiles.put(new Point(x*32,y*32), tile);
			}
		}
	}

	@Override
	public void tick() {
	}
}
