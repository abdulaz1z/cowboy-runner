package com.cowboy.state;

import java.awt.*;
import java.awt.event.KeyEvent;

import com.cowboy.resource.Resource;

/**
 * This is the loading state of the game where we load all 
 * the game assets and show the user a loading screen.
 * 
 * @author Abdul Aziz
 */
public class InitState extends State {
    
	/**
     * Method for initializing and loading assets.
     */
	@Override
    public void init() {
		Resource.load();
    }

	/**
     * Method for updating this state's game objects.
     * 
     * @param deltaMillis Time elapsed since last update
     */
    @Override
    public void update(float deltaMillis) {

    }

    /**
     * Method for rendering this state's game objects on the screen.
     *
     * @param g The Graphics objects needed to draw
     */
    @Override
    public void draw(Graphics g) {
    	g.drawImage(Resource.welcome, 0, 0, null);
    }

    /**
     * Method for handling a key pressed on this state.
     *
     */
    @Override
    public boolean keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        return true;
    }

    /**
     * Method for handling a key released on this state.
     *
     */
    @Override
    public boolean keyReleased(KeyEvent e) {
        System.out.println("keyReleased");
        return true;
    }
}
