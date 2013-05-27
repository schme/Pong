
package com.laughingmasq.pong.game;

import com.laughingmasq.pong.graphics.SpriteType;

/**
 * Pad object used to create playing pads.
 * @author schme
 */
public class Pad extends Entity {
	
	private int width = 0;
	private int height = 0;
	


	/**
	 * Create a pad with a type, position and size.
	 * @param type		Type of the pad.
	 * @param posX		Given X coordinate.
	 * @param posY		Given Y coordinate.
	 * @param width		Given width of the pad.
	 * @param height	Given height of the pad.
	 */
    public Pad(SpriteType type, float posX, float posY, int width, int height) {
    	super(type,posX,posY);
    	
    	this.width = width;
    	this.height = height;
    }
    
    
    public int getWidth() {
		return width;
	}
    
    public int getHeight() {
		return height;
	}

    @Override
    public void moveWithin2D(float spaceWidth, float spaceHeight) {
    	//TODO: Implement
    	move();
    }
    
}
