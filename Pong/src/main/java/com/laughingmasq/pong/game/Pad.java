
package com.laughingmasq.pong.game;

import com.laughingmasq.pong.EntityType;

/**
 * Pad object used to create playing pads.
 * @author schme
 */
public class Pad extends Entity {
	
	private int width = 0;
	private int height = 0;
	
	/** pixels per frame */
	private float moveVelocity = 10;


	/**
	 * Create a pad with a type, position and size.
	 * Position is the bottom left corner of the pad.
	 * 
	 * @param type		Type of the pad.
	 * @param posX		Given X coordinate.
	 * @param posY		Given Y coordinate.
	 * @param width		Given width of the pad.
	 * @param height	Given height of the pad.
	 */
    public Pad(EntityType type, float posX, float posY, int width, int height) {
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
    
    
    /**
     * Sets the pad to move up.
     */
    public void movingUp() {
    	setVelY(moveVelocity);
    }
    
    
    /**
     * Sets the pad to move down.
     */
    public void movingDown() {
    	setVelY(-moveVelocity);
    }
    
    
    /**
     * Stops all movement from the pad.
     */
    public void stop() {
    	setVelX(0);
    	setVelY(0);
    }
    
    
    @Override
    public void moveWithin2D(float spaceWidth, float spaceHeight) {
    	
    	/** if we would crash the top of the border, just move to the edge */
    	if( getPosY() + getVelY() > spaceHeight - height) { 
    		setPosY( spaceHeight - height);
    	}
    	
    	/** if we crash to the bottom, just move to the edge */
    	else if( getPosY() + getVelY() < 0) {
    		setPosY( 0);
    	}
    	
    	/** we crash nowhere, so use the regular move method */
    	else {
    		move();
    	}
    }
    
}
