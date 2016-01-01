package tk.thetechnokid.game.entities.mapobjects;

import java.awt.*;
import java.util.HashMap;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.entities.Entity;
import tk.thetechnokid.game.entities.Tile;

public abstract class MapObject extends Entity {

	protected HashMap<Point, Tile> tiles = new HashMap<>();
	protected final int w, h;

	public MapObject(int x, int y, int w, int h) {
		super(x, y);
		this.w = w;
		this.h = h;
		generateTiles();
	}

	@Override
	public void render(Graphics g) {
		for (Point p : tiles.keySet()) {
			Tile t = tiles.get(p);
			g.drawImage(t.getImage(), p.x /*- Game.cam.getxOffset()*/, p.y /*- Game.cam.getyOffset()*/, null);
		}
	}

	@Override
	public Rectangle bounds() {
		return new Rectangle(x * 32, y * 32, w * 32, h * 32);
	}

	protected abstract void generateTiles();
}
