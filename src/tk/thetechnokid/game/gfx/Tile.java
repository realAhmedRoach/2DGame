package tk.thetechnokid.game.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.entities.Entity;

public class Tile extends Entity {

	private static Spritesheet s;

	static {
		try {
			s = new Spritesheet(ImageIO.read(new File("res/spritesheet.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// TILES
	public static Tile VOID = new Tile(s.crop(0, 0, 32, 32), false);
	public static Tile GRASS = new Tile(s.crop(0, 1, 32, 32), false);
	public static Tile ROCK = new Tile(s.crop(0, 2, 32, 32), true);
	public static Tile WATER1 = new Tile(s.crop(0, 3, 32, 32), false);
	public static Tile WATER2 = new Tile(s.crop(0, 4, 32, 32), false);
	public static Tile DIRT = new Tile(s.crop(0, 5, 32, 32), false);
	public static Tile PORTAL = new Tile(s.crop(0, 6, 32, 32), false);
	// END TILES
	BufferedImage image;
	boolean solid;

	public Tile(BufferedImage image, boolean solid) {
		super(0,0,image);
		this.solid = solid;
	}

	public boolean isSolid() {
		return solid;
	}

	@Override
	public void move() {
	}
}
