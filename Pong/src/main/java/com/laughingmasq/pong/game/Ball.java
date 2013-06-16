package com.laughingmasq.pong.game;

import java.awt.Rectangle;

import com.laughingmasq.pong.EntityType;

/**
 * Ball object for logic.
 * 
 * TODO: Methods in this class are getting a bit too big. Would be fixed with
 * a better collision implementation.
 * 
 * @author schme
 */
public class Ball extends Entity {

	/** Initial radius, subject to change during the game */
    private int radius = 10;
    /** Used to avoid bouncing inside an object */
    private boolean justCollided = false;

    /**
     * Ball with no arguments creates a ball to the position 0, 0
     */
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
    
    
    /**
     * Create a ball to the center of board with set x and y velocity.
     * @param boardWidth	Width of the used board
     * @param boardHeight	Height of the used board
     * @param xVelocity		Initial x velocity
     * @param yVelocity		Initial y velocity
     */
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
     * @param velocity	Velocity of the pad.
     * @return	Amount to add to the balls Y velocity.
     */
    private float getEnglish(float velocity) {
    	return velocity/2;
    }
    
    
    /**
     * Check if we collide with a rectangle object. Handles the problem of
     * multiple collisions.
     * 
     * @param rec	Rectangle we check against.
     * @return		True if marked collision, false if not
     */
    protected boolean collidesWithRectangle(Rectangle rec) {
    	
    	boolean collision = false;

    	collision = rec.intersects(new Rectangle(
    		(int)(getPosX() - radius), (int)(getPosY() - radius), 
    		radius*2, radius*2));

    	/* new collision */
    	if( collision && !justCollided ) { 
    		justCollided = false; 
  		}
    	/* still in a collision */
    	else if( collision && justCollided ) { 
    		return false; 
    	}
    	/* out of a collision */
    	else if( !collision && justCollided ) {
    		justCollided = false;
    	}
    	return collision;
    }
    
    
    /**
     * Checks if we're on top, to the right, left or at the bottom of the pad.
     * TODO: We're really making too many rectangles here. Just use the friggin'
     * reference already and store it somewhere! Just move it around!
     * TODO: Learn to code.
     * @param pad	Pad we check for
     * @return		The Rectangle2D static: OUT_BOTTOM, OUT_LEFT, OUT_RIGHT, OUT_TOP.
     */
    protected int positionFromPad(Pad pad) {
    	Rectangle r = new Rectangle((int)pad.getPosX(), (int)pad.getPosY() - (int)(pad.getHeight()), 
    			(int)pad.getWidth(), (int)pad.getHeight());
    	
    	return r.outcode(getPosX(), getPosY());
    }
    
    /**
     * A check to see if we've gone beyond a border or not.
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
     * Java awt uses different coordinates than OpenGL (which the logic uses),
     * so this stuff will seem very weird.
     * @param pad	The pad we are testing against.
     * @return		True if collides, false otherwise
     */
    public boolean collidesWith(Pad pad) {
    	
    	return collidesWithRectangle(
    			new Rectangle((int)pad.getPosX(), (int)pad.getPosY() - (int)pad.getHeight(), 
    						(int)pad.getWidth(), (int)pad.getHeight()));
    }
    
    
    /**
     * Handles the collision with a pad: changing directions, proper english etc.
     * @param baseYVel		Base Y velocity of the ball
     * @param pad			Pad we collided with
     */
    public void collideWithPad(float baseYVel, Pad pad) {
    	
    	/** A Rectangle static OUT value */
    	int position = positionFromPad(pad);
    	
    	
    	/* apply english if pad and ball go the same direction */
    	if( pad.getVelY() > 0 && getVelY() > 0) {
    		setVelY(baseYVel + getEnglish(pad.getVelY()));
    	}
    	else if( pad.getVelY() < 0 && getVelY() < 0) {
    		setVelY(-baseYVel + getEnglish(pad.getVelY()));
    	}

    	
    	/* collided at top or bottom */
    	if( getPosY() > pad.getPosY() ||
        	getPosY() < pad.getPosY() - pad.getHeight())
        {
        	setVelY(getVelY() * -1);
        }
    	
    	if( position == Rectangle.OUT_BOTTOM || position == Rectangle.OUT_TOP) {
    		setVelY(getVelY() * -1);
    	}
    	else if( position == Rectangle.OUT_LEFT || position == Rectangle.OUT_RIGHT) {
    		setVelX(getVelX() * -1);
    	}
    }
    
    
    /**
     * A quick test to determine the side.
     * @param boardWidth 	Width of the tested board
     * @return				True if ball is at the left side, false otherwise
     */
    public boolean atLeftSide(float boardWidth) {
    	if( getPosX() < boardWidth/2) {
    		return true;
    	}
    	return false;
    }
    
    
    /**
     * Resets the ball position to the middle with given velocities.
     * Ball doesn't store the board size, so it has to be given again.
     * @param boardWidth		Width of the board.
     * @param boardHeight		Height of the board.
     * @param velocityX			New x velocity.
     * @param velocityY			New y velocity.
     */
    public void reset(float boardWidth, float boardHeight, float velocityX, float velocityY) {
    	setPosX(boardWidth/2); setPosY(boardHeight/2);
    	setVelX(velocityX); setVelY(velocityY);
    }
    
    
    /**
     * If the ball meats a border it turns back in a mirror angle.
     * Does not handle collision with other entities.
     * TODO: Still travel the whole trip if you're going to collide.
     * @param spaceWidth		Width of the used space (usually board width)
     * @param spaceHeight		Height of the used space (usually board height)
     * @return					True if we collide at the player ends (player scores)
     */
    @Override
    public boolean moveWithin2D(float spaceWidth, float spaceHeight) {
    	
    	boolean xCollides = collidesWithBorder(getPosX() + getVelX(), spaceWidth);
    	boolean yCollides = collidesWithBorder(getPosY() + getVelY(), spaceHeight);
    	
    	if( xCollides ) {
    		setVelX(getVelX() * -1);
    		return true;
    	}
    	
    	if( yCollides) {
    		setVelY(getVelY() * -1);
    	}
    	
    	if( !xCollides && !yCollides) {
    		move();
    	}
    	return false;
    }
    
}