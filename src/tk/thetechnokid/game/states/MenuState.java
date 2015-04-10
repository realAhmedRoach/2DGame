package tk.thetechnokid.game.states;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.control.InputHandler;
import tk.thetechnokid.game.entities.Tile;

public class MenuState extends State {

	private String newStuff = "Added Bosses";

	private BufferedImage RUNNER;
	private BufferedImage bg;

	public MenuState() {
		RUNNER = Tile.s.crop(0, 6, 73, 27);
		try {
			bg = ImageIO.read(Game.class.getResource("/bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(bg, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.drawImage(RUNNER, (Game.WIDTH / 2) - (RUNNER.getWidth() + 30), 100, RUNNER.getWidth() * 3,
				RUNNER.getHeight() * 3, null);
		g.setFont(new Font("Segoe Script", Font.PLAIN, 21));
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("NEW: " + newStuff, 20, 45);
		g.setColor(Color.DARK_GRAY);
		String s = "Space to Start";
		g.drawString(s, 300, Game.HEIGHT / 2);
	}

	@Override
	public void tick() {
		if (InputHandler.isSpace())
			State.setState(new GameState());
	}

}
