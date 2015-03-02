package tk.thetechnokid.game.states;

import java.awt.Graphics;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.control.EntityController;
import tk.thetechnokid.game.control.LevelGenerator;
import tk.thetechnokid.game.gfx.Map;

public class GameState extends State {

	public GameState() {
		Map.generateTiles();
		LevelGenerator.generateRandomLevel();
	}

	@Override
	public void render(Graphics g) {
		Map.render(g);
		EntityController.render(g);
	}

	@Override
	public void tick() {
		EntityController.tick();
		if(EntityController.enemies.isEmpty()) {
			LevelGenerator.generateRandomLevel();
			Game.LEVEL++;
		} if(!EntityController.entities.contains(EntityController.user)) {
			State.setState(new EndGameState());
		}
	}

}
