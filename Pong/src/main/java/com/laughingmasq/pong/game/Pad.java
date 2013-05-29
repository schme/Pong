
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
	
	/** for adding acceleration */
	private boolean moving = false;


	/**
	 * Create a pad with a type, position and size.
	 * Position is the bottom left corner of the pad.
	 * 
	 * @param type			Type of the pad.
	 * @param boardWidth	Width of the used board.
	 * @param boardHeight	Height of the used board.
	 */
    public Pad(EntityType type, float boardWidth, float boardHeight) {
    	super(type);
    	
    	if( type == EntityType.LEFTPAD) {
    		setPosX( PADDING);
    		setPosY( boardHeight/2 - HEIGHT/2);
    		
    	} else if( type == EntityType.RIGHTPAD) {
    		setPosX( boardWidth - PADDING - WIDTH);
    		setPosY( boardHeight/2 - HEIGHT/2);
    	}
    }
    
    
    public float getWidth() {
		return WIDTH;
	}
    
    public float getHeight() {
		return HEIGHT;
	}
    
    
    /**
     * Sets the pad to move up.
     */
    public void movingUp() {
    	moving = true;
    	setVelY(MOVE_VELOCITY);
    }
    
    
    /**
     * Sets the pad to move down.
     */
    public void movingDown() {
    	moving = true;
    	setVelY(-MOVE_VELOCITY);
    }
    
    
    /**
     * Stops all movement from the pad.
     */
    public void stop() {
    	setVelX(0);		// just in case
    	setVelY(0);
    	moving = false;
    }
    
    
    @Override
    public void moveWithin2D(float spaceWidth, float spaceHeight) {
    	
    	/**
    	 * TODO: Fix: The other player can prevent other players acceleration
    	 * by wiggling their pad up and down.
    	 */
    	if( moving) {
    		if( Math.abs(getVelY()) > MAX_ACCELERATION) { 
    			setVelY( (getVelY() > 0 ? MAX_ACCELERATION : -MAX_ACCELERATION));
    		} else {
    			setVelY(getVelY() * BASE_ACCELERATION);
    		}
    	}
    	
    	/** if we would crash the top of the border, just move to the edge */
    	if( getPosY() + getVelY() > spaceHeight - HEIGHT) { 
    		setPosY( spaceHeight - HEIGHT);
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
