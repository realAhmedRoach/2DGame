package tk.thetechnokid.game.entities;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Entity {
	public int x;
	public int y;
	private BufferedImage image;
	public boolean destroyed;
	protected int width;
	protected int height;
	
	public Entity(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.image = image;
		width = this.image.getWidth();
		height = this.image.getHeight();
	}
	public abstract void move();
	public BufferedImage getImage() {
		return image;
	}
	
	public void render(Graphics g) {
		if(!destroyed) g.drawImage(getImage(), x, y, getImage().getWidth(), getImage().getHeight(), null);
	}
	
	public Rectangle bounds() {
		Rectangle r = new Rectangle(x,y,width,height);
		return r;
	}
}
