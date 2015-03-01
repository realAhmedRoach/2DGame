package tk.thetechnokid.game.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.Game;

public class EndGameState extends State {

	BufferedImage image;

	public EndGameState() {
		try {
			image = ImageIO.read(new File("res/endgame.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, 0, 0, null);
		g.setFont(new Font("Viner Hand ITC", Font.PLAIN, 24));
		g.drawString("Kills: "+Game.KILLS, 300, 350);
		g.drawString("Level: "+Game.LEVEL, 300, 400);
	}

	@Override
	public void tick() {
	}

}
