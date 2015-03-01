package tk.thetechnokid.game.states;

import java.awt.Graphics;

public abstract class State {
	static State currentState;

	public static State getCurrentState() {
		return currentState;
	}

	public static void setState(State state) {
		currentState = state;
	}

	public abstract void render(Graphics g);
	public abstract void tick();
}
