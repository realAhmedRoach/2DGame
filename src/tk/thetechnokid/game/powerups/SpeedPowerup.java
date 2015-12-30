package tk.thetechnokid.game.powerups;

import tk.thetechnokid.game.entities.Player;
import tk.thetechnokid.game.entities.Tile;

public class SpeedPowerup extends Powerup {

	private static final int OFFSET = 2;

	public SpeedPowerup() {
		image = Tile.s.crop(0, 5);
		name = "Speed Boost";
	}

	@Override
	public void happen() {
		Player.SPEED += OFFSET;
	}

	@Override
	public void destroy() {
		Player.SPEED -= OFFSET;
	}
}
