package tk.thetechnokid.game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.gfx.Spritesheet;

public class Tile extends Entity {

	public static Spritesheet s;

	static {
		try {
			s = new Spritesheet(ImageIO.read(Game.class.getResource("/spritesheet.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// TILES
	public static Tile VOID = new Tile(s.crop(0, 0), false);
	public static Tile GRASS = new Tile(s.crop(1, 0), false);
	public static Tile ROCK = new Tile(s.crop(2, 0), true);
	public static Tile WATER1 = new Tile(s.crop(3, 0), false);
	public static Tile WATER2 = new Tile(s.crop(4, 0), false);
	public static Tile DIRT = new Tile(s.crop(5, 0), false);
	public static Tile PORTAL = new Tile(s.crop(6, 0), false);
	public static Tile TREE = new Tile(s.crop(7, 0), false);
	// END TILES

	BufferedImage image;
	boolean solid;

	public Tile(BufferedImage image, boolean solid) {
		super(0, 26, image);
		this.solid = solid;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, null);
	}

	public boolean isSolid() {
		return solid;
	}

	@Override
	public void tick() {
	}
}