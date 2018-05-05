package com.cowboy.state;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.cowboy.resource.Resource;

/**
 * This is the loading state of the game where we load all 
 * the game assets and show the user a loading screen.
 * 
 * @author Abdul Aziz
 */
public class InitState extends State {
	private boolean isDoneLoading;
	private int counter = 0;
    
	/**
     * Method for initializing and loading assets.
     */
	@Override
    public void init() {
		isDoneLoading = false;
		Resource.load();
		isDoneLoading = true;
    }

	/**
     * Method for updating this state's game objects.
     * 
     * @param deltaMillis Time elapsed since last update
     */
    @Override
    public void update(float deltaMillis) {
    	counter++;
    	if(isDoneLoading && counter >= 150) {
    		this.setCurrentState(new MenuState());
    	}
    	Resource.loadingAnimation.update(deltaMillis);
    }
    
    /**
     * Method for rendering this state's game objects on the screen.
     *
     * @param g The Graphics objects needed to draw
     */
    @Override
    public void draw(Graphics g) {
    	g.drawImage(Resource.background, 0, 0, null);
    	g.drawImage(Resource.backgroundGrass, 0, 0, null);
    	Resource.loadingAnimation.render(g, 0, 0);
    }

    /**
     * Method for handling a key pressed on this state.
     *
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
    }

    /**
     * Method for handling a key released on this state.
     *
     */
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased");
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouse clicked");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
