package tk.thetechnokid.game.states;

import java.awt.*;
import java.awt.image.BufferedImage;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.control.InputHandler;
import tk.thetechnokid.game.entities.Tile;

public class MenuState extends State {

	private String newStuff = "Added Bosses";

	private BufferedImage RUNNER;

	public MenuState() {
		RUNNER = Tile.s.crop(0, 6, 73, 26);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(RUNNER, (Game.WIDTH / 2) - (RUNNER.getWidth()*3), 100, RUNNER.getWidth() * 3,
				RUNNER.getHeight() * 3, null);
		g.setFont(new Font("Segoe Script", Font.PLAIN, 21));
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("NEW: " + newStuff, 20, 45);
	}

	@Override
	public void tick() {
		if (InputHandler.isSpace())
			State.setState(new GameState());
	}

}
