package com.laughingmasq.pong.game;

import com.laughingmasq.pong.graphics.Sprite;
import com.laughingmasq.pong.graphics.SpriteFactory;
import com.laughingmasq.pong.graphics.SpriteType;

public abstract class Entity {
	
	private float posX;
	private float posY;
	
	private float velX;
	private float velY;
	
	private Sprite sprite;
	
	
	public Entity (SpriteType type, float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
		
		this.velX = 0;
		this.velY = 0;
		
		this.sprite = new SpriteFactory(type).create(this);
	}

	
	public float getPosX() {
		return posX;
	}
	
	public float getPosY() {
		return posY;
	}
	
	public double getVelX() {
		return velX;
	}
	
	public double getVelY() {
		return velY;
	}
	
	
	public void setPosX(float posX) {
		this.posX = posX;
	}
	
	public void setPosY(float posY) {
		this.posY = posY;
	}
	
	public void setVelX(float velX) {
		this.velX = velX;
	}
	
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	
	public void move() {
		this.posX += velX;
		this.posY += velY;
	}
	
	public void draw() {
		sprite.draw();
	}
	
}