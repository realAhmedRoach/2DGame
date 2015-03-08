package tk.thetechnokid.game.powerups;

import tk.thetechnokid.game.entities.Player;
import tk.thetechnokid.game.entities.Tile;

public class SpeedPowerup extends Powerup {

	private boolean finished;

	public SpeedPowerup() {
		image = Tile.s.crop(0, 5);
		name = "Speed Boost";
	}

	@Override
	public void handle(boolean shooting) {
		if(finished) return;
		Player.SPEED = 5;
		if((startTime-System.currentTimeMillis())>=maxTime) destroy();
	}

	@Override
	public void destroy() {
		finished = true;
		Player.SPEED = 4;
	}
}
