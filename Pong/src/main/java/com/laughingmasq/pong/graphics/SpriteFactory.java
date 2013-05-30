package com.laughingmasq.pong.graphics;

import com.laughingmasq.pong.EntityType;
import com.laughingmasq.pong.game.Entity;


/**
 * Used when entity is created, to give it the corresponding sprite.
 * 
 * Exists for easier sprite creation.
 * @author schme
 *
 */
public class SpriteFactory {
	
	private EntityType type;
	
	public SpriteFactory(EntityType type) {
		this.type = type;
	}
	
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