package tk.thetechnokid.game.states;

import java.awt.Graphics;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.control.EntityController;
import tk.thetechnokid.game.control.LevelGenerator;

public class GameState extends State {

	public GameState() {
		LevelGenerator.generateRandomLevel();
	}

	@Override
	public void render(Graphics g) {
		// Map.render(g);
		EntityController.render(g);
	}

	@Override
	public void tick() {
		EntityController.tick();
		if(EntityController.enemies.isEmpty()) {
			LevelGenerator.generateRandomLevel();
			Game.LEVEL++;
			System.out.println(Game.LEVEL);
		} if(!EntityController.entities.contains(EntityController.user)) {
			State.setState(new EndGameState());
		}
	}

}
