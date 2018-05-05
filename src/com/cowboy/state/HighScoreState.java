package com.cowboy.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import com.cowboy.main.Game;
import com.cowboy.resource.Resource;

public class HighScoreState extends State {
	private Rectangle goBack;
	private int highscore = 0;
	@Override
	public void init() {
		goBack = new Rectangle(Game.GAME_WIDTH/2 - 140, Game.GAME_HEIGHT/2 + 25, 285, 68);
		try {
			highscore = Resource.getHighScore();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		g.setColor(new Color(255,255,153));
		//g.drawRect(Game.GAME_WIDTH/2 - 140, Game.GAME_HEIGHT/2 + 25, 285, 68);
		g.fillRect(Game.GAME_WIDTH/2 - 140, Game.GAME_HEIGHT/2 + 25, 285, 68);
		g.setColor(new Color(102,51,50));
		g.drawString("Main Menu",Game.GAME_WIDTH/2 - 125,Game.GAME_HEIGHT/2 + 75);
		g.drawString("Your HighScore is "+ highscore, Game.GAME_WIDTH/2 - 215, 180);
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
		int mx = e.getX();
		int my = e.getY();
		if(goBack.contains(mx,my)){
			this.setCurrentState(new MenuState());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
