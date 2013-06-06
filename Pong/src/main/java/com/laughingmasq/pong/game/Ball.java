package com.laughingmasq.pong.game;

import java.awt.Point;
import java.awt.Rectangle;

import com.laughingmasq.pong.EntityType;

/**
 * Ball object for logic.
 * 
 * @author schme
 */
public class Ball extends Entity {

	/** Initial radius, subject to change during the game */
    private int radius = 12;
    private boolean justCollided = false;

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
    }
    
    
    /**
     * Create a ball to the center of board with set x velocity.
     * @param boardWidth	Width of the used board
     * @param boardHeight	Height of the used board
     * @param xVelocity		Used x velocity for the ball
     */
    public Ball(float boardWidth, float boardHeight, float xVelocity) {
    	this(boardWidth, boardHeight);
    	
    	setVelX(xVelocity);
    }
    
    
    public Ball(float boardWidth, float boardHeight, float xVelocity, float yVelocity) {
    	this(boardWidth, boardHeight, xVelocity);
    	
    	setVelY(yVelocity);
    }
    
    
    public int getRadius() {
		return radius;
	}
    
    
    /**
     * Return the amount of velocity we get from given velocity (if the pad
     * we hit is moving).
     * @param velocity	Of the pad.
     * @return	Amount to add to the balls Y velocity.
     */
    private float getEnglish(float velocity) {
    	return velocity/2;
    }
    
    
    /**
     * Check if we collide with a rectangle.
     * 
     * Ugly. So ugly and inefficient.
     * @param rec	Rectangle we check against.
     * @return
     */
    protected boolean collidesWithRectangle(Rectangle rec) {
    	
    	/* If the ball is not at the same height as pad */
    	if( getPosY() - radius > rec.y || getPosY() + radius < rec.y - rec.height) {
    		return false;
    	}
    	else {
    		
    		/* ball is at right from the rectangle */
    		if( getPosX() - radius > rec.x + rec.width) {
    			return rec.contains(new Point((int)(getPosX() - radius), (int)getPosY()));
    		
    		/* ball is at left from the rectangle */
    		} else if( getPosX() + radius < rec.x ){
    			return rec.contains(new Point((int)(getPosX() + radius), (int)getPosY()));
    		}
    		
    		return true;
    	}
    	
    	
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
     * Ugly, but the proper implementations requires bigger changes.
     * Change if time allows.
     * @param pad	The pad we are testing against.
     * @return	True if collides, false otherwise
     */
    public boolean collidesWith(Pad pad) {
    	
    	return collidesWithRectangle(
    			new Rectangle((int)pad.getPosX(), (int)pad.getPosY(), 
    						(int)pad.getWidth(), (int)pad.getHeight()));
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
    
    
    @Override
    public boolean collidesWith(Entity entity) {

    	return false;
    }
    
    
    public void collideWithPad(float baseYVel, Pad pad) {
    	setVelX(getVelX() * -1);
    	setVelY(baseYVel + getEnglish(pad.getVelY()));
    }
}