package tk.thetechnokid.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import tk.thetechnokid.game.control.EntityController;
import tk.thetechnokid.game.control.InputHandler;
import tk.thetechnokid.game.control.LevelGenerator;
import tk.thetechnokid.game.entities.Player;

public class Game extends JFrame implements Runnable {
	private static final long serialVersionUID = 6639258471146102807L;

	private static final String TITLE = "Game";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 700;

	private boolean running;
	private Thread thread;

	public Game() {
		setResizable(false);
		setTitle(TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(new InputHandler());
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		requestFocus();
		setLocationRelativeTo(null);
	}

	public void tick() {
		EntityController.tick();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, getWidth(), getHeight());
		EntityController.render(g);
		g.dispose();
		bs.show();
	}

	private void init() {
		LevelGenerator.generateRandomLevel();
		Player user = new Player();
		EntityController.setUser(user);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		init();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			render();
		}
		stop();
	}

	public static void main(String[] args) {
		new Game().start();
	}

}
