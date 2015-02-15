package tk.thetechnokid.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import tk.thetechnokid.game.control.EntityController;
import tk.thetechnokid.game.control.InputHandler;
import tk.thetechnokid.game.entities.Bullet;
import tk.thetechnokid.game.entities.Enemy;
import tk.thetechnokid.game.entities.Entity;
import tk.thetechnokid.game.entities.Player;

public class Main extends JFrame implements Runnable {
	private static final long serialVersionUID = 6639258471146102807L;

	private static final String TITLE = "Game";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private boolean running;
	private Thread thread;

	public Main() {
		init();
		setResizable(false);
		setTitle(TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		requestFocus();
		setLocationRelativeTo(null);
	}

	public void tick() {
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		paintComponent(g);
		g.dispose();
		bs.show();
	}

	public void paintComponent(Graphics g) {
		for (Entity entity : EntityController.entities) {
			entity.move();
			entity.render(g);
			if (entity instanceof Player) {
				Player p = (Player) entity;
				for (Bullet b : p.bullets) {
					b.move();
					b.render(g);
				}
			}
		}
	}

	private void init() {
		Player user = new Player(150, 150);
		Enemy enemy = new Enemy(WIDTH, HEIGHT);
		
		EntityController.setUser(user);
		EntityController.setEnemy(enemy);
		
		addKeyListener(new InputHandler());
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
		while (running) {
			tick();
			render();
		}
	}

	public static void main(String[] args) {
		new Main().start();
	}

}
