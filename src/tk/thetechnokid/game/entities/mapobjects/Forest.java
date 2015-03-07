package tk.thetechnokid.game.entities.mapobjects;

import java.awt.Point;

import tk.thetechnokid.game.entities.Tile;

public class Forest extends MapObject {

	public Forest(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	protected void generateTiles() {
		for (int x = this.x; x < this.x + w; x++) {
			for (int y = this.y; y < this.y + h; y++) {
				boolean grass = Math.random() <= .3;
				Tile tile = !grass ? Tile.TREE : Tile.GRASS;
				tiles.put(new Point(x * 32, y * 32), tile);
			}
		}
	}

	@Override
	public void tick() {
	}
}
