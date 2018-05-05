package com.cowboy.state;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.cowboy.main.Game;

/**
 * This class is an abstract class that represent a state of the game (InitState, PlayState and so on).
 *
 * @author Abdul Aziz
 */
public abstract class State {
    /**
     * Method for setting the current state of the game.
     *
     * @param newState The new current state of the game
     */
    public void setCurrentState(State newState) {
    	Game.setCurrentState(newState);
    }

    /**
     * Method for initializing and loading assets for the current state.
     */
    public abstract void init();

    /**
     * Method for updating the current state's game objects.
     * 
     * @param Time elapsed since last update
     */
    public abstract void update(float deltaMillis);

    /**
     * Method for rendering the game's objects on the screen.
     *
     * @param g The Graphics objects needed to draw
     */
    public abstract void draw(Graphics g);

    /**
     * Method for handling a key pressed on the current state.
     *
     */
    public abstract void keyPressed(KeyEvent e);

    /**
     * Method for handling a key released on the current state.
     *
     */
    public abstract void keyReleased(KeyEvent e);
    
    /**
     * Method for handling a mouse clicked on the current state.
     *
     */
    public abstract void mouseClicked(MouseEvent e);

    /**
     * Method for handling a mouse released on the current state.
     *
     */
    public abstract void mouseReleased(MouseEvent e);
}