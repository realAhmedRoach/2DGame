package tk.thetechnokid.game.states;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.control.InputHandler;
import tk.thetechnokid.game.entities.Tile;

public class EndGameState extends State {

	private BufferedImage RUNNER;

	public EndGameState() {
		RUNNER = Tile.s.crop(0, 6, 73, 26);
	}


	@Override
	public void render(Graphics g) {
		g.drawImage(RUNNER, (Game.WIDTH / 2) - (RUNNER.getWidth()*3), 100, RUNNER.getWidth() * 3,
				RUNNER.getHeight() * 3, null);
		g.setFont(new Font("Viner Hand ITC", Font.PLAIN, 24));
		g.setColor(new Color(65, 30, 24));
		g.drawString("Kills: " + Game.KILLS, 300, 350);
		g.drawString("Level: " + Game.LEVEL, 300, 400);

		g.setColor(Color.decode("0x2b520e"));
		g.drawString("Press \"s\" to save stats", 250, 500);
	}

	@Override
	public void tick() {
		if (InputHandler.isSpace()) {
			Game.LEVEL = 1;
			Game.KILLS = 0;
			State.setState(new GameState());
		}
		if (InputHandler.isEsc())
			System.exit(0);
		if (InputHandler.getKeys()[KeyEvent.VK_S])
			saveScores();
	}

	private void saveScores() {
		File saveFile = new File(System.getProperty("user.home") + "/Desktop/runner_save.txt");

		try {
			BufferedWriter r = new BufferedWriter(new FileWriter(saveFile));

			r.write("Level: " + Game.LEVEL + System.getProperty("line.separator"));
			r.write("Kills: " + Game.KILLS + System.getProperty("line.separator"));

			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
