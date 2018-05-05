package com.cowboy.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.cowboy.resource.Resource;
import com.cowboy.util.Background;

public class PlayState extends State{
	private Background background;
	
	@Override
	public void init() {
		background = new Background();
	}

	@Override
	public void update(float deltaMillis) {
		background.update();
		Resource.playerRun.update(deltaMillis);
		
	}

	@Override
	public void draw(Graphics g) {
		background.draw(g);
		Resource.playerRun.draw(g, 400, 440);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
