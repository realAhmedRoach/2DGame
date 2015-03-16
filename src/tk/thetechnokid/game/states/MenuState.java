package tk.thetechnokid.game.states;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.Game;
import tk.thetechnokid.game.control.InputHandler;

public class MenuState extends State {

	private BufferedImage menuImage;
	private String newStuff = "Added Bosses";

	public MenuState() {
		try {
			menuImage = ImageIO.read(Game.class.getResource("/menu.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(menuImage, 0, 0,null);
		g.setFont(new Font("Segoe Script", Font.PLAIN, 21));
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("NEW: " + newStuff, 20, 45);
	}

	@Override
	public void tick() {
		if(InputHandler.isSpace()) State.setState(new GameState());
	}

}
