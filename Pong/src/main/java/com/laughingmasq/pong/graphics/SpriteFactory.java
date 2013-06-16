package com.laughingmasq.pong.graphics;

import com.laughingmasq.pong.EntityType;
import com.laughingmasq.pong.game.Entity;


/**
 * Used when entity is created, to give it the corresponding sprite. When you
 * create an entity which you want to draw, add its sprite class here.
 * 
 * Exists for easier sprite creation.
 * @author schme
 *
 */
public class SpriteFactory {
	
	private EntityType type;
	
	
	/**
	 * Type of the entity we want..
	 * @param type
	 */
	public SpriteFactory(EntityType type) {
		this.type = type;
	}
	
	
	/**
	 * Create a sprite. This class exists solely for this method.
	 * @param e		Entity for which we create the sprite.
	 * @return		Created sprite.
	 */
	public Sprite create(Entity e) {
		
		Sprite sprite = null;
		
		switch(type) {
			case BALL:
				sprite = new BallSprite(e);
				break;
			case LEFTPAD:
				sprite = new LeftPadSprite(e);
				break;
			case RIGHTPAD:
				sprite = new RightPadSprite(e);
				break;
		}
		
		return sprite;
	}
	
}