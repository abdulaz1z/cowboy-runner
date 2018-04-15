package com.cowboy.state;

import java.awt.*;
import java.awt.event.KeyEvent;

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
        //TODO: set the newState to the current state to Game.java
    }

    /**
     * Method for initializing and loading assets for the current state.
     */
    public abstract void init();

    /**
     * Method for updating the current state's game objects.
     */
    public abstract void update();

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
    public abstract boolean keyPressed(KeyEvent e);

    /**
     * Method for handling a key released on the current state.
     *
     */
    public abstract boolean keyReleased(KeyEvent e);
}