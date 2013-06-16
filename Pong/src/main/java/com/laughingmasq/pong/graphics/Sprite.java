package com.laughingmasq.pong.graphics;

import com.laughingmasq.pong.game.Entity;

/**
 * Super class for all sprites. Defines draw() method but doesn't implement.
 * Stores the given entity. There is no sprite that has no corresponding entity
 * (yet at least). All sprites should work through this super class.
 * @author schme
 *
 */
public abstract class Sprite {
	
	/** entity for the sprite  */
	private Entity entity;
	
	/**
	 * Stores the entity. Must be called by the implementing sprite class.
	 * @param entity	Corresponding entity.
	 */
	public Sprite(Entity entity) {
		this.entity = entity;
	}
	
	protected Entity getEntity() {
		return entity;
	}
	
	/**
	 * Gets the x position from the entity.
	 * @return		x position
	 */
	protected float getPositionX() {
		return entity.getPosX();
	}
	
	/**
	 * Gets the y position from the entity.
	 * @return		y position
	 */
	protected float getPositionY() {
		return entity.getPosY();
	}
	
	
	/**
	 * Draw the sprite. Raw opengl commands.
	 */
	abstract public void draw();

}
