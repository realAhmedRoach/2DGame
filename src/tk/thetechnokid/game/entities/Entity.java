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
	
	public Entity(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.sprite = image;
		width = this.sprite.getWidth();
		height = this.sprite.getHeight();
	}
	public abstract void move();
	public BufferedImage getImage() {
		return sprite;
	}
	
	public void render(Graphics g) {
		if(!destroyed) g.drawImage(sprite, x, y, sprite.getWidth(), sprite.getHeight(), null);
	}
	
	public Rectangle bounds() {
		Rectangle r = new Rectangle(x,y,width,height);
		return r;
	}
}
