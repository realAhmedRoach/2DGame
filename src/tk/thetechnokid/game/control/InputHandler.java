package tk.thetechnokid.game.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
	private static final int MAX_KEY = 130;
	private static boolean[] keys = new boolean[MAX_KEY];
	private static boolean up;
	private static boolean down;
	private static boolean right;
	private static boolean left;
	private static boolean space;
	private static boolean esc;

	private void update() {
		up = getKeys()[KeyEvent.VK_UP];
		down = getKeys()[KeyEvent.VK_DOWN];
		right = getKeys()[KeyEvent.VK_RIGHT];
		left = getKeys()[KeyEvent.VK_LEFT];
		space = getKeys()[KeyEvent.VK_SPACE];
		esc = getKeys()[KeyEvent.VK_ESCAPE];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() > MAX_KEY)
			return;
		getKeys()[e.getKeyCode()] = true;
		update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() > MAX_KEY)
			return;
		getKeys()[e.getKeyCode()] = false;
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

	public static boolean isEsc() {
		return esc;
	}

	public static boolean[] getKeys() {
		return keys;
	}
}
