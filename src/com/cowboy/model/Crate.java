package com.cowboy.model;

import java.awt.Rectangle;
import java.util.Random;

public class Crate {
	public float x;
	public float y;
	
	public int width;
	public int height;

	public Rectangle rect;
	public boolean visible;
	public static final int UPPER_Y = 400;
	public static final int LOWER_Y = 495;
	
	private Random random;

	public Crate(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		rect = new Rectangle((int) x, (int) y, width, height);
		visible = false;
		
		random = new Random();
	}

	public void update(float velX) {
		x += velX;
		if (x <= -300) {
			reset();
		}
		updateRect();
	}

	public void updateRect() {
		rect.setBounds((int) x, (int) y, width, height);
	}

	public void reset() {
		visible = true;
		// 1 in 3 chance of becoming an Upper Block
		if (random.nextInt(3) == 0) {
			y = UPPER_Y;
		} else {
			y = LOWER_Y;
		}
		x += 1500;
	}

	public void onCollide(Player p) {
		visible = false;
	}
}