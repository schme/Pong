package com.laughingmasq.pong.graphics;

import com.laughingmasq.pong.graphics.SpriteType;

public class SpriteFactory {
	
	private SpriteType type;
	
	public SpriteFactory(SpriteType type) {
		this.type = type;
	}
	
	public Sprite create() {
		
		Sprite sprite = null;
		
		switch(type) {
			case BALL:
				sprite = new BallSprite();
				break;
			case LEFTPAD:
				sprite = new LeftPadSprite();
				break;
			case RIGHTPAD:
				sprite = new RightPadSprite();
				break;
		}
		
		return sprite;
	}
	

}