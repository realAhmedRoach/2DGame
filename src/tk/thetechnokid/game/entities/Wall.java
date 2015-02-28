package tk.thetechnokid.game.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tk.thetechnokid.game.control.EntityController;

public class Wall extends Entity {

	private static BufferedImage image;

	static {
		try {
			image = ImageIO.read(new File("res/wall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Wall(int x, int y) {
		super(x, y, image);
	}

	@Override
	public void tick() {
		if(EntityController.user.bounds().intersects(bounds())) {
			EntityController.user.x = x + 5;
			EntityController.user.y = y + 5;
		}
	}
}
