package tk.thetechnokid.game.powerups;

import tk.thetechnokid.game.entities.Player;
import tk.thetechnokid.game.entities.Tile;

public class SpeedPowerup extends Powerup {

	public SpeedPowerup() {
		image = Tile.s.crop(0, 5);
		name = "Speed Boost";
	}

	@Override
	public void happen() {
		Player.SPEED = 5;
	}

	@Override
	public void destroy() {
		Player.SPEED = 4;
	}
}
