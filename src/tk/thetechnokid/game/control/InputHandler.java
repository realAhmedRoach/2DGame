package tk.thetechnokid.game.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
	private boolean[] keys = new boolean[130];
	private static boolean up;
	private static boolean down;
	private static boolean right;
	private static boolean left;
	private static boolean space;

	private void update() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		right = keys[KeyEvent.VK_RIGHT];
		left = keys[KeyEvent.VK_LEFT];
		space = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		update();
	}

	public static boolean isUp() {
		return up;
	}

	public static boolean isDown() {
		return down;
	}

	public static boolean isRight() {
		return right;
	}

	public static boolean isLeft() {
		return left;
	}

	public static boolean isSpace() {
		return space;
	}
}
