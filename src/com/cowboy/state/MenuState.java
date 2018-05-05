package com.cowboy.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.cowboy.main.Game;
import com.cowboy.resource.Resource;

public class MenuState extends State{
	private Rectangle start;
	private Rectangle highscore;
	private int mx,my;
	
	@Override
	public void init() {
		start = new Rectangle(Game.GAME_WIDTH/2 - 77, Game.GAME_HEIGHT/2 - 63, 200, 75);
		highscore = new Rectangle(Game.GAME_WIDTH/2 - 150, Game.GAME_HEIGHT/2 + 45, 350, 75);
	}

	@Override
	public void update(float deltaMillis) {
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(Resource.background,0,0,null);
		g.drawImage(Resource.backgroundGrass,0,0,null);
		g.setFont(new Font("TimesRoman", Font.BOLD, 50));
		g.setColor(new Color(102,51,50));
		//g.drawRect(start.x, start.y, start.width, start.height);
		g.fillRect(start.x, start.y, start.width, start.height);
		//g.drawRect(highscore.x, highscore.y, highscore.width, highscore.height);
		g.fillRect(highscore.x, highscore.y, highscore.width, highscore.height);
		g.setColor(new Color(254,211,105));
		g.drawString("START", Game.GAME_WIDTH/2 - 60, Game.GAME_HEIGHT/2 - 10);
		g.drawString("HIGHSCORE", Game.GAME_WIDTH/2 - 130, Game.GAME_HEIGHT/2 + 100);
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
		mx = e.getX();
		my = e.getY();
		if(start.contains(mx, my)){
			this.setCurrentState(new PlayState());
		}
		if(highscore.contains(mx, my)){
			this.setCurrentState(new HighScoreState());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
