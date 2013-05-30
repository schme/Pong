package com.laughingmasq.pong.game;

import java.util.Random;

import com.laughingmasq.pong.EntityType;

/**
 * Ball object for logic.
 * 
 * @author schme
 */
public class Ball extends Entity {

	/** Initial radius, subject to change during the game */
    private int radius = 12;
    
    private Random rng;

    public Ball() {
		super(EntityType.BALL, 0, 0);
	}

    
    /**
     * Create a ball to the center of board and a random velocity.
     * @param boardWidth	Width of the used board
     * @param boardHeight	Height of the used board
     */
    public Ball(float boardWidth, float boardHeight) {
    	super(EntityType.BALL, 0, 0);
    	
    	
    	if( boardWidth <= 0 || boardHeight <= 0) {
    		setPosX(0); setPosY(0);
    	} else {
    		setPosX(boardWidth/2); setPosY(boardHeight/2);
    	}
    	
    	
    	//TODO: fix this, then test this
    	rng = new Random();
    	setVelX(rng.nextFloat() * 15);
    	setVelY(rng.nextFloat() * 15);
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
    protected boolean collidesWithBorder(float position, float border) {
    	if( position - radius > 0 &&
    		position + radius <= border) {
    		return false;
    	}
    	
    	return true;
    }
    
    
    /**
     * If the ball meats a border it turns back in a mirror angle.
     * TODO: Still travel the whole trip if you're going to collide.
     */
    @Override
    public void moveWithin2D(float spaceWidth, float spaceHeight) {

    	boolean xCollides = collidesWithBorder(getPosX() + getVelX(), spaceWidth);
    	boolean yCollides = collidesWithBorder(getPosY() + getVelY(), spaceHeight);
    	
    	if( xCollides ) {
    		setVelX(getVelX() * -1);
    	}
    	
    	if( yCollides) {
    		setVelY(getVelY() * -1);
    	}
    	
    	if( !xCollides && !yCollides) {
    		move();
    	}
    }
}