package tk.thetechnokid.game.powerups;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Powerup {

	BufferedImage image;
	String name;
	public int x, y;
	protected long startTime;
	protected long maxTime;
	protected boolean finished;

	public Powerup() {
		startTime = System.currentTimeMillis();
		maxTime = 1000;
	}

	public void render(Graphics g, int x, int y) {
		g.drawString(name, x+15, y);
		g.drawImage(image, x, y+15, null);
	}

	public final void handle() {
		if(finished) return;
		happen();
		if((startTime-System.currentTimeMillis())>=maxTime) destroy();
	}
	public abstract void destroy();
	public abstract void happen();

	public BufferedImage getImage() {
		return image;
	}

	public String getName() {
		return name;
	}


}
