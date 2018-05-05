package com.cowboy.main;

import java.applet.Applet;
import java.awt.*;

import com.cowboy.state.InitState;
import com.cowboy.state.State;
import com.cowboy.util.InputHandler;

/**
 * This is the starting point of this application where the main game lives. We
 * have the game loop running in its own thread and game logics within.
 * 
 * @author Abdul Aziz
 */
public class Game extends Applet implements Runnable {
	public static final String GAME_NAME = "Cowboy Runner";
	public static final int GAME_WIDTH = 1000;
	public static final int GAME_HEIGHT = 580;

	Image offScreen;
	Graphics offG;

	static InputHandler inputHandler;
	public static State currentState;
	volatile boolean running = false;

	Thread gameThread;

	/**
	 * Method for initializing the game variables and starting the game thread.
	 */
	@Override
	public void init() {
		offScreen = this.createImage(Game.GAME_WIDTH, Game.GAME_HEIGHT);
		offG = offScreen.getGraphics();

		inputHandler = new InputHandler();
		currentState = new InitState();
		currentState.init();
		inputHandler.currentState = currentState;

		setupApplet();
		requestFocus();
		addKeyListener(inputHandler);
		addMouseListener(inputHandler);
		initializeGame();
	}

	/**
	 * Method for setting up the applet.
	 */
	private void setupApplet() {
		// get the parent frame to change the title
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle(Game.GAME_NAME);
		frame.setResizable(false);
		setSize(Game.GAME_WIDTH, Game.GAME_HEIGHT);
	}

	/**
	 * Method for initializing and starting the game loop.
	 */
	private void initializeGame() {
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	/**
     * Method for running the game loop in its own thread.
     */
    @Override
	public void run() {
		long updateDurationMillis = 0; // Measures both update AND render
		long sleepDurationMillis = 0; // Measures sleep

		while (running) {
			long beforeUpdateDraw = System.nanoTime();
			long deltaMillis = sleepDurationMillis + updateDurationMillis;

			updateGameObjects(deltaMillis);
			prepareOffScreenImage();

			updateDurationMillis = (System.nanoTime() - beforeUpdateDraw) / 1000000L; // convert to milliseconds
			sleepDurationMillis = Math.max(2, 17 - updateDurationMillis); // sleep at least 2 seconds

			repaint();
			try {
				Thread.sleep(sleepDurationMillis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method for updating the game objects checking for collision.
	 * 
	 * @param deltaMillis Time elapsed since last update
	 */
	private void updateGameObjects(float deltaMillis) {
		currentState.update(deltaMillis);
	}

	/**
	 * Method for clearing the off screen image and drawing.
	 */
	private void prepareOffScreenImage() {
		offG.clearRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
		paint(offG);
	}

	/**
     * Method for drawing the off screen image on the screen.
     */
    @Override
	public void update(Graphics g) {
		g.drawImage(offScreen, 0, 0, null);
	}

    /**
     * Method for drawing game objects on the screen.
     */
	public void paint(Graphics g) {
		currentState.draw(g);		
	}
	
	/**
     * Method for setting the current state of the game.
     *
     * @param newState The new current state of the game
     */
    public static void setCurrentState(State newState) {
    	System.gc();
    	currentState.init();
    	currentState = newState;
    	inputHandler.currentState = newState;
    }
}