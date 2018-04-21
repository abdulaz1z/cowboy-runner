package com.cowboy.state;

import com.cowboy.resource.Resource;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * This is the loading state of the game where we load all 
 * the game assets and show the user a loading screen.
 * 
 * @author Abdul Aziz
 */
public class InitState extends State {
    
	/**
	 * Method to load all the game assets.
	 */
	@Override
    public void init() {
		Resource.load();
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public boolean keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        return true;
    }

    @Override
    public boolean keyReleased(KeyEvent e) {
        System.out.println("keyReleased");
        return true;
    }
}
