package com.laughingmasq.pong.graphics;

import com.laughingmasq.pong.game.Entity;

public abstract class Sprite {
	
	private Entity entity;
	
	private double posX;
	private double posY;
	
	public Sprite(Entity e) {
		this.entity = e;
		this.posX = e.getPosX();
		this.posY = e.getPosY();
	}
	
	protected Entity getEntity() {
		return entity;
	}
	
	abstract public void draw();

}
