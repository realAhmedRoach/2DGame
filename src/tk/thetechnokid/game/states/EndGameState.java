package tk.thetechnokid.game.states;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.control.InputHandler;

public class EndGameState extends State {

	BufferedImage image;

	public EndGameState() {
		try {
			image = ImageIO.read(Game.class.getResource("/endgame.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, 0, 0, null);
		g.setFont(new Font("Viner Hand ITC", Font.PLAIN, 24));
		g.setColor(new Color(65,30,24));
		g.drawString("Kills: "+Game.KILLS, 300, 350);
		g.drawString("Level: "+Game.LEVEL, 300, 400);

		g.setColor(Color.decode("0x2b520e"));
		g.drawString("Press \"s\" to save stats", 250, 500);
	}

	@Override
	public void tick() {
		if(InputHandler.isSpace()) {
			Game.LEVEL = 1;
			Game.KILLS = 0;
			State.setState(new GameState());
		} if(InputHandler.isEsc()) System.exit(0);
		if(InputHandler.getKeys()[KeyEvent.VK_S]) saveScores();
	}

	private void saveScores() {
		File saveFile = new File(System.getProperty("user.home")+"/Desktop/runner_save.txt");

		try {
			BufferedWriter r = new BufferedWriter(new FileWriter(saveFile));

			r.write("Level: "+Game.LEVEL+"\n");
			r.write("Kills: "+Game.KILLS+"\n");

			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
