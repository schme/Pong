package com.laughingmasq.pong.game;

import com.laughingmasq.pong.graphics.Sprite;
import com.laughingmasq.pong.graphics.SpriteTypes;

public abstract class Entity {
	
	private double posX;
	private double posY;
	
	private double velX;
	private double velY;
	
	private Sprite sprite;
	
	
	public Entity (SpriteTypes type, double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
		
		this.velX = 0;
		this.velY = 0;
		
		this.sprite = new SpriteFactory(type).create();
	}

	
	public double getPosX() {
		return posX;
	}
	
	public double getPosY() {
		return posY;
	}
	
	public double getVelX() {
		return velX;
	}
	
	public double getVelY() {
		return velY;
	}
	
	
	public void setPosX(double posX) {
		this.posX = posX;
	}
	
	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	public void setVelX(double velX) {
		this.velX = velX;
	}
	
	public void setVelY(double velY) {
		this.velY = velY;
	}
	
	
	public void move() {
		this.posX += velX;
		this.posY += velY;
	}
	
	public void draw() {}
	
}