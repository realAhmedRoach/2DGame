package tk.thetechnokid.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Entity {
	public int x;
	public int y;
	protected BufferedImage sprite;
	public boolean destroyed;
	protected int width;
	protected int height;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Entity(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.sprite = image;
		width = this.sprite.getWidth()*2;
		height = this.sprite.getHeight()*2;
	}

	public abstract void tick();

	public BufferedImage getImage() {
		return sprite;
	}

	public void render(Graphics g) {
		if (!destroyed)
			g.drawImage(sprite, x, y, width, height, null);
	}

	public Rectangle bounds() {
		Rectangle r = new Rectangle(x, y, width, height);
		return r;
	}
}
