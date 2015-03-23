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
	public static Tile VOID = new Tile(s.crop(0, 0));
	public static Tile GRASS = new Tile(s.crop(1, 0));
	public static Tile ROCK = new Tile(s.crop(2, 0));
	public static Tile WATER1 = new Tile(s.crop(3, 0));
	public static Tile WATER2 = new Tile(s.crop(4, 0));
	public static Tile DIRT = new Tile(s.crop(5, 0));
	public static Tile PORTAL = new Tile(s.crop(6, 0));
	public static Tile TREE = new Tile(s.crop(7, 0));
	// END TILES

	BufferedImage image;

	public Tile(BufferedImage image) {
		super(0, 26, image);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, null);
	}

	@Override
	public void tick() {
	}
}
