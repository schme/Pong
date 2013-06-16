
package com.laughingmasq.pong.game;

import com.laughingmasq.pong.EntityType;

/**
 * Pad object used to create playing pads.
 * @author schme
 */
public class Pad extends Entity {
	
	/** pixels */
	protected static float PADDING = 50;
	protected static float WIDTH = 15;
	protected static float HEIGHT = 140;
	
	/** pixels per frame */
	protected static float MOVE_VELOCITY = 10;
	protected static float MAX_ACCELERATION = 2.5f * MOVE_VELOCITY;
	
	/** times the velocity */
	protected static float BASE_ACCELERATION = 1.05f;
	
	/** if we moved the previous frame */
	private boolean moving = false;


	/**
	 * Create a pad with a type and position (position depends on the type)
	 * Position coordinate is the top left corner of the pad.
	 * 
	 * @param type			Type of the pad.
	 * @param boardWidth	Width of the used board.
	 * @param boardHeight	Height of the used board.
	 */
    public Pad(EntityType type, float boardWidth, float boardHeight) {
    	super(type);
    	
    	if( type == EntityType.LEFTPAD) {
    		setPosX( PADDING);
    		setPosY( boardHeight/2 + HEIGHT/2);
    		
    	} else if( type == EntityType.RIGHTPAD) {
    		setPosX( boardWidth - PADDING - WIDTH);
    		setPosY( boardHeight/2 + HEIGHT/2);
    	}
    	  	
    }
    
    
    public float getWidth() {
		return WIDTH;
	}
    
    public float getHeight() {
		return HEIGHT;
	}
    
    /**
     * Sets the pad to move up (upgrades velocity).
     */
    public void movingUp() {
    	moving = true;
    	setVelY(MOVE_VELOCITY);
    }
    
    
    /**
     * Sets the pad to move down (upgrades velocity).
     */
    public void movingDown() {
    	moving = true;
    	setVelY(-MOVE_VELOCITY);
    }
    
    
    /**
     * Stops all movement from the pad (sets velocity to zero).
     */
    public void stop() {
    	setVelX(0);		// just in case
    	setVelY(0);
    	moving = false;
    }
    
    
    /**
     * Moves the pad within certain boundaries.
     * 
     * Handles the acceleration of the pad when it has been in a continuous
     * movement.
     * @param spaceWidth	Spaces X boundary.
     * @param spaceHeight	Spaces Y boundary.
     */
    @Override
    public boolean moveWithin2D(float spaceWidth, float spaceHeight) {
    	
    	/**
    	 * Add acceleration to paddle when moving.
    	 * TODO: Fix: The other player can prevent other players acceleration
    	 * by wiggling their pad up and down (no idea why this happens).
    	 */
    	if( moving ) {
    		if( Math.abs(getVelY()) > MAX_ACCELERATION) { 
    			setVelY( (getVelY() > 0 ? MAX_ACCELERATION : -MAX_ACCELERATION));
    		} else {
    			setVelY(getVelY() * BASE_ACCELERATION);
    		}
    	}
    	
    	/** if we would crash the top of the border, just move to the edge */
    	if( getPosY() + getVelY() > spaceHeight) { 
    		setPosY( spaceHeight);
    		return true;
    	}
    	
    	/** if we crash to the bottom, just move to the edge */
    	else if( getPosY() + getVelY() < HEIGHT) {
    		setPosY( HEIGHT);
    		return true;
    	}
    	
    	/** we crash nowhere, so use the regular move method */
    	else {
    		move();
    	}
    	
    	return false;
    }
    
}
