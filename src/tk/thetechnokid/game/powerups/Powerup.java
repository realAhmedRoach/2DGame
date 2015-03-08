package tk.thetechnokid.game.powerups;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Powerup {

	BufferedImage image;
	String name;
	public int x, y;

	public Powerup(BufferedImage image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}

	public void render(Graphics g) {
		g.drawString(name, x+15, y);
		g.drawImage(image, x, y+15, null);
	}

	public abstract void handle(boolean shooting);
	public abstract void destroy();

	public BufferedImage getImage() {
		return image;
	}

	public String getName() {
		return name;
	}


}
