
package com.laughingmasq.pong.game;

import com.laughingmasq.pong.graphics.SpriteType;

/**
 * @author schme
 */
public class Pad extends Entity {
	
	private int width = 50;
	private int height = 140;
	
	//How far the pad should be from the side
	//TODO: adjust
	private int padding = 50;

	
    public Pad(SpriteType type, double boardWidth, double boardHeight) {
    	super(type,0,0);
    	
    	//Left pad
    	if(type == SpriteType.LEFTPAD) {
    		super.setPosX(padding);
    		super.setPosY(boardHeight/2 - height/2);
    	//Right pad
    	} else if(type == SpriteType.RIGHTPAD) {
    		super.setPosX(boardWidth - width - 50);
    		super.setPosY(boardHeight/2 - height/2);
    	}
    	
    }
    
    
    public int getWidth() {
		return width;
	}
    
    public int getHeight() {
		return height;
	}

    
}
