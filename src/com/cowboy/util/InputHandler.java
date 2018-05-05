package com.cowboy.util;

import com.cowboy.state.State;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class will handle all the user interaction on the current state. This is a helper
 * class for handling all the user interaction with the game.
 *
 * @author Abdul Aziz
 */
public class InputHandler implements KeyListener, MouseListener{
    public State currentState;

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

	@Override
	public void mouseClicked(MouseEvent e) {
		currentState.mouseClicked(e);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentState.mouseReleased(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
