package com.laughingmasq.pong.graphics;

import com.laughingmasq.pong.game.Entity;
import com.laughingmasq.pong.graphics.SpriteType;

public class SpriteFactory {
	
	private SpriteType type;
	
	public SpriteFactory(SpriteType type) {
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