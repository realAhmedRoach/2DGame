package tk.thetechnokid.game.entities;

public abstract class MapObject extends Entity {

	protected final int w,h;

	public MapObject(int x, int y,int w, int h) {
		super(x, y);
		this.w=w;
		this.h=h;
	}

	protected abstract void generateTiles();
}
