package com.cowboy.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.cowboy.resource.Resource;

public class PlayState extends State{
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float deltaMillis) {
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(Resource.gameBackground, 0, 0, null);
		g.drawImage(Resource.bgLayer3, 0, 0, null);
		g.drawImage(Resource.bgLayer1, 0, 0, null);
		g.drawImage(Resource.bgLayer2, 0, 0, null);
		g.drawImage(Resource.backgroundGrass, 0, 0, null);
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
