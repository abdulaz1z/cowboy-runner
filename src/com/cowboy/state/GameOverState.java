package com.cowboy.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.cowboy.main.Game;
import com.cowboy.resource.Resource;

public class GameOverState extends State {
	private int score;
	
	public GameOverState(int score) {
		this.score = score;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(float deltaMillis) {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(Resource.gameBackground, 0, 0, null);
		g.drawImage(Resource.bgLayer3, 0, 0, null);
		g.drawImage(Resource.bgLayer1, 0, 0, null);
		g.drawImage(Resource.bgLayer2, 0, 0, null);
		g.drawImage(Resource.backgroundGrass, 0, 0, null);
		g.setFont(new Font("TimesRoman", Font.BOLD, 50));
		g.setColor(new Color(102,51,50));
		g.drawString("Game Over", Game.GAME_WIDTH/2 - 140, 100);
		g.drawString("Your Score is " + score, Game.GAME_WIDTH/2 - 200, 175);

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
