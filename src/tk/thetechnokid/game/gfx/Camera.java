package tk.thetechnokid.game.gfx;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.entities.Creature;

public class Camera {

	private int xOffset, yOffset;

	public Camera(int x, int y) {
		xOffset = x;
		yOffset = y;
	}

	public void centerOnEntity(Creature e) {
		xOffset = e.x - Game.WIDTH / 2;
		yOffset = e.y - Game.HEIGHT/ 2;
	}

	public void move(int xa, int ya) {
		xOffset += xa;
		yOffset += ya;
	}

	public int getxOffset() {
		return xOffset;
	}

	public void setxOffset(int xOffset) {
		this.xOffset = xOffset;
	}

	public int getyOffset() {
		return yOffset;
	}

	public void setyOffset(int yOffset) {
		this.yOffset = yOffset;
	}
}
