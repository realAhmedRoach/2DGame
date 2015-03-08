package tk.thetechnokid.game.powerups;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Powerup {

	BufferedImage image;
	String name;
	public int x, y;
	protected long startTime;
	protected long maxTime;

	public Powerup() {
		startTime = System.currentTimeMillis();
		maxTime = 1000;
	}

	public void render(Graphics g, int x, int y) {
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
