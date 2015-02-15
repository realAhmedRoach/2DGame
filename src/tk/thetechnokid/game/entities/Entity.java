package tk.thetechnokid.game.entities;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {
	public int x;
	public int y;
	private BufferedImage image;
	public boolean destroyed;
	
	public Entity(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.image = image;
	}
	public abstract void move();
	public BufferedImage getImage() {
		return image;
	}
	
	public void render(Graphics g) {
		if(!destroyed) g.drawImage(getImage(), x, y, getImage().getWidth(), getImage().getHeight(), null);
	}
}
