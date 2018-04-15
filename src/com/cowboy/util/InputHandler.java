package com.cowboy.util;

import com.cowboy.state.State;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class will handle all the user interaction on the current state. This is a helper
 * class for handling all the user interaction with the game.
 *
 * @author Abdul Aziz
 */
public class InputHandler implements KeyListener{
    State currentState;

    /**
     * Method for handling any typed keys.
     *
     * @param e The event that took place
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Method for handling any pressed keys.
     *
     * @param e The event that took place
     */
    @Override
    public void keyPressed(KeyEvent e) {
        currentState.keyPressed(e);
    }

    /**
     * Method for handling any released keys.
     *
     * @param e The event that took place
     */
    @Override
    public void keyReleased(KeyEvent e) {
        currentState.keyReleased(e);
    }
}
