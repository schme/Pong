package com.laughingmasq.pong.graphics;

import com.laughingmasq.pong.EntityType;
import com.laughingmasq.pong.game.Entity;

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