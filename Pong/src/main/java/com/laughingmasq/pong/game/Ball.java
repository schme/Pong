package com.laughingmasq.pong.game;

import java.util.Random;

import com.laughingmasq.pong.graphics.SpriteType;

/**
 * Ball object for logic.
 * 
 * @author schme
 */
public class Ball extends Entity {

    private int radius = 15;
    
    private Random rng;

    public Ball() {
		super(SpriteType.BALL, 0, 0);
	}

    
    /**
     * Create a ball with given coordinations and a random velocity.
     * @param posX	Given X coordinate
     * @param posY	Given Y coordinate
     */
    public Ball(float posX, float posY) {
    	super(SpriteType.BALL, posX, posY);
    	
    	rng = new Random();
    	setVelX(rng.nextFloat() * 5);
    	setVelY(rng.nextFloat() * 5);
    }
    
    public int getRadius() {
		return radius;
	}
    
    
    /**
     * A check to see if given position and border with Entity's size fits.
     * @param position	Given position.
     * @param strain	Given border.
     * @return	True if inside the given restrains.
     */
    private boolean insideBorder(float position, float border) {
    	if( position - radius > 0 &&
    		position + radius <= border) {
    		
    		return true;
    	}
    	
    	return false;
    }
    
    
    @Override
    /**
     * If the ball meats a border it turns back in a mirror angle.
     * TODO: Still travel the trip if you're going to collide.
     */
    public void moveWithin2D(float spaceWidth, float spaceHeight) {

    	boolean xInside = insideBorder(getPosX() + getVelX(), spaceWidth);
    	boolean yInside = insideBorder(getPosY() + getVelY(), spaceHeight);
    	
    	if( !xInside ) {
    		setVelX(getVelX() * -1);
    	}
    	if( !yInside) {
    		setVelY(getVelY() * -1);
    	}
    	
    	move();
    }
}