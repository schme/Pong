package com.laughingmasq.pong.game;

import com.laughingmasq.pong.graphics.Sprite;
import com.laughingmasq.pong.graphics.SpriteFactory;
import com.laughingmasq.pong.graphics.SpriteType;


/**
 * Super class for all entities (especially movable) in the game.
 * 
 * @param type
 * @author schme
 *
 */
public abstract class Entity {
	
	private float posX = 0;
	private float posY = 0;
	
	private float velX = 0;
	private float velY = 0;
	
	private Sprite sprite = null;
	
	
	/**
	 * Create an Entity with all values 0 or null.
	 */
	public Entity () {}
	
	/**
	 * Create an Entity with a type. Will create a Sprite object.
	 * @param type	Type of the Entity object.
	 */
	public Entity (SpriteType type) {
		this.sprite = new SpriteFactory(type).create(this);
	}
	
	/**
	 * Create an Entity with a position but a null Sprite object.
	 * @param posX	Given X coordinate.
	 * @param posY	Given Y coordinate.
	 */
	public Entity (float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
		
		this.velX = 0;
		this.velY = 0;
		
		this.sprite = null;
	}
	
	/**
	 * Create an Entity with a position and a type. Creates the Sprite object.
	 * @param type	Type of the Entity object
	 * @param posX	Given X coordinate.
	 * @param posY	Given Y coordinate.
	 */
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
	
	public float getVelX() {
		return velX;
	}
	
	public float getVelY() {
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
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	
	/**
	 * Adds the velocities to corresponding position values, no checks.
	 */
	public void move() {
		posX += velX;
		posY += velY;
	}
	
	
	/**
	 * Move with a given velocity.
	 * @param amountX	Given velocity for X.
	 * @param amountY	Given velocity for Y.
	 */
	public void moveAmount(float amountX, float amountY) {
		posX += amountX;
		posY += amountY;
	}
	
	
	/**
	 * Calls Sprite objects draw method (if sprite != null).
	 */
	public void draw() {
		if( sprite != null) {
			sprite.draw();
		}
	}
	

	/**
	 * Move within a 2D space.
	 * @param spaceWidth
	 * @param spaceHeight
	 */
	abstract public void moveWithin2D(float spaceWidth, float spaceHeight);
	
}