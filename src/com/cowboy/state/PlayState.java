package com.cowboy.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.cowboy.main.Game;
import com.cowboy.model.Crate;
import com.cowboy.model.Player;
import com.cowboy.resource.Resource;
import com.cowboy.util.Background;
import com.cowboy.util.Grass;

public class PlayState extends State{
	private Background background;
	private Grass grass;
	private Player player;
	
	private static final int PLAYER_WIDTH = 66;
	private static final int PLAYER_HEIGHT = 92;
	
	private int score = 0;
	private int health = 5;
	
	private ArrayList<Crate> crates;
	private static final int CRATE_HEIGHT = 50;
	private static final int CRATE_WIDTH = 50;
	private int blockSpeed = -6;
	
	@Override
	public void init() {
		background = new Background();
		grass = new Grass();
		player = new Player(200, Game.GAME_HEIGHT - 48 - PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		
		crates = new ArrayList<>();
		for (int i = 1; i < 6; i++) {
			Crate crate = new Crate(i * 300, Game.GAME_HEIGHT, CRATE_WIDTH, CRATE_HEIGHT);
			crates.add(crate);
		}
	}

	@Override
	public void update(float deltaMillis) {
		background.update();
		grass.update();
		Resource.playerRun.update(deltaMillis);
		Resource.playerJump.update(deltaMillis);
		Resource.playerSlide.update(deltaMillis);
		Resource.playerDead.update(deltaMillis);
	
		if(health <= 0) {
			player.die();
		}
		
		player.update(deltaMillis);
		if(!player.isAlive) {
			this.setCurrentState(new GameOverState(score));
		}
		
		for (Crate crate : crates) {
			crate.update(blockSpeed);
			if (crate.visible) {
				if (player.isSliding && crate.rect.intersects(player.slideRect)) {
					health--;
					crate.onCollide(player);
				}
				else if(!player.isGrounded() && crate.rect.intersects(player.jumpRect)) {
					health--;
					crate.onCollide(player);
				}
				else if(!player.isSliding && crate.rect.intersects(player.runRect)) {
					health--;
					crate.onCollide(player);
				}
			}
		}
		
		score += 1;
		if (score % 1000 == 0 && blockSpeed > -280) {
			blockSpeed -= 1;
		}
	}

	@Override
	public void draw(Graphics g) {
		background.draw(g);
		player.draw(g);
		
		for (Crate crate : crates) {
			if (crate.visible) {
				g.drawImage(Resource.crate, (int) crate.x, (int) crate.y, CRATE_WIDTH, CRATE_HEIGHT, null);
			}
		}
		
		grass.draw(g);
		
		g.drawString("SCORE: " + score/100 + "", 50, 50);
		g.drawString("HEALTH: " + health + "", 650, 50);
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
