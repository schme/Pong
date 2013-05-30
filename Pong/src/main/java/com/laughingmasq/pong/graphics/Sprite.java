package com.laughingmasq.pong.graphics;

import com.laughingmasq.pong.game.Entity;

/**
 * Super class for all sprites. Defines draw() method but doesn't implement.
 * @author schme
 *
 */
public abstract class Sprite {
	
	private Entity entity;
	
	public Sprite(Entity entity) {
		this.entity = entity;
	}
	
	protected Entity getEntity() {
		return entity;
	}
	
	protected float getPositionX() {
		return entity.getPosX();
	}
	
	protected float getPositionY() {
		return entity.getPosY();
	}
	
	abstract public void draw();

}
