package com.cowboy.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.cowboy.main.Game;
import com.cowboy.model.Player;
import com.cowboy.resource.Resource;
import com.cowboy.util.Background;

public class PlayState extends State{
	private Background background;
	private Player player;
	
	private static final int PLAYER_WIDTH = 66;
	private static final int PLAYER_HEIGHT = 92;
	
	@Override
	public void init() {
		background = new Background();
		player = new Player(200, Game.GAME_HEIGHT - 48 - PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
	}

	@Override
	public void update(float deltaMillis) {
		background.update();
		Resource.playerRun.update(deltaMillis);
		Resource.playerJump.update(deltaMillis);
		Resource.playerSlide.update(deltaMillis);
		Resource.playerDead.update(deltaMillis);
	
		player.update(deltaMillis);
		if(!player.isAlive) {
			this.setCurrentState(new GameOverState());
		}
	}

	@Override
	public void draw(Graphics g) {
		background.draw(g);
		player.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.jump();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.slide();
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.die();
		}
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
