package com.cowboy.model;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.cowboy.resource.Resource;

public class Player {
	public float x;
	public float y; 
	public int width;
	public int height;
	public int velY;	
	
	public Rectangle runRect;
	public Rectangle slideRect;
	public Rectangle jumpRect;
	public Rectangle ground;

	public boolean isAlive;
	public boolean isSliding;
	public boolean isDying;
	float dyingDuration = 400;
	float slideDuration = 550;

	static final int JUMP_VELOCITY = -16;
	static final int ACCEL_GRAVITY = 1;

	public Player(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		ground = new Rectangle(0, 542, 1000, 40);
		runRect = new Rectangle();
		jumpRect = new Rectangle();
		slideRect = new Rectangle();
		isAlive = true;
		isDying = false;
		isSliding = false;
		updateRects();
	}

	public void update(float delta) {
		if (slideDuration > 0 && isSliding) {
			slideDuration -= delta;
		} else {
			isSliding = false;
			slideDuration = 550;
		}
		
		if (dyingDuration > 0 && isDying) {
			dyingDuration -= delta;
		} else {
			if(isDying) {
				isAlive = false;
			}
		}
		
		
		if (!isGrounded()) {
			velY += ACCEL_GRAVITY;
		} else {
			if(!isSliding) {
				y = 535 - height;
				velY = 0;
			}
		}
		y += velY;
		updateRects();
		
	}
	
	public void draw(Graphics g) {
		if (isGrounded()) {
			if (isSliding) {
				Resource.playerSlide.draw(g, (int)x, (int)y);
				//g.drawRect(slideRect.x, slideRect.y, slideRect.width, slideRect.height);
			} 
			else if (isDying) {
				Resource.playerDead.draw(g, (int)x, (int)y);
			}
			else {
				Resource.playerRun.draw(g, (int)x, (int)y);
				//g.drawRect(runRect.x, runRect.y, runRect.width, runRect.height);
			}
		} else {
			if (isDying) {
				Resource.playerDead.draw(g, (int)x, (int)y);
			}
			else {
				Resource.playerJump.draw(g, (int)x, (int)y);
				//g.drawRect(jumpRect.x, jumpRect.y, jumpRect.width, jumpRect.height);
			}
		}
		
		//for debugging
		//g.drawRect(ground.x, ground.y, ground.width, ground.height);
	}

	public void updateRects() {
		runRect.setBounds((int) x + 12, (int) y, width - 5, height + 12);
		jumpRect.setBounds((int) x + 5, (int) y + 12, width, height - 5);
		slideRect.setBounds((int) x, (int) y + 20, width + 22, height - 24);
	}

	public void jump() {
		if (isGrounded()) {
			isSliding = false;
			slideDuration = 550;
			y -= 10;
			velY = JUMP_VELOCITY;
			updateRects();
		}
	}

	public void slide() {
		if (isGrounded()) {
			if(!isSliding) {
				isSliding = true;
				//TODO: remove this
				y += 25;
				updateRects();
			}
		}
	}
	
	public void die() {
		isSliding = false;
		isDying = true;
	}

	public boolean isGrounded() {
		if(isSliding) return slideRect.intersects(ground);
		else return runRect.intersects(ground);
	}
}