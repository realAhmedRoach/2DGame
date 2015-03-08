package tk.thetechnokid.game.powerups;

import java.awt.image.BufferedImage;

import tk.thetechnokid.game.entities.Player;
import tk.thetechnokid.game.entities.Tile;

public class SpeedPowerup extends Powerup {

	public SpeedPowerup(BufferedImage image, int x, int y) {
		super(Tile.s.crop(0,5), x, y);
		name = "Speed Boost";
	}

	@Override
	public void handle(boolean shooting) {
		Player.SPEED = 5;
	}

	@Override
	public void destroy() {
		Player.SPEED = 4;
	}
}
