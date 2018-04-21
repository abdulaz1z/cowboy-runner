package com.cowboy.main;

import com.cowboy.state.InitState;
import com.cowboy.state.State;
import com.cowboy.util.InputHandler;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * This is the starting point of this application where the main game lives. 
 * We have the game loop running in its own thread and game logics within.
 * 
 * @author Abdul Aziz
 */
public class Game extends Applet implements Runnable{
	public static final String GAME_NAME = "Cowboy Runner";
	public static final int GAME_WIDTH = 1000;
	public static final int GAME_HEIGHT = 500;
	
	Image offScreen;
	Graphics offG;
	
    InputHandler inputHandler;
    State currentState;

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
        inputHandler.currentState = currentState;
        
        //get the parent frame to change the title
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle(Game.GAME_NAME);
        setSize(Game.GAME_WIDTH, Game.GAME_HEIGHT);

        requestFocus();
        addKeyListener(inputHandler);

        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Method for running the game loop in its own thread.
     */
    @Override
    public void run() {
    	//TODO: #28 - add the game loop in the run method
    }
    
    /**
     * Method for clearing the off screen image and drawing.
     */
    public void update(Graphics g) {
    	offG.clearRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
    	paint(offG);
    	g.drawImage(offScreen, 0, 0, null);
    }
    
    /**
     * Method for drawing game objects on the screen.
     */
    public void paint(Graphics g) {
    	
    }
}
