package com.laughingmasq.pong.game;

import java.awt.Rectangle;

import com.laughingmasq.pong.EntityType;

/**
 * Ball object for logic.
 * 
 * @author schme
 */
public class Ball extends Entity {

	/** Initial radius, subject to change during the game */
    private int radius = 10;
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
     * @param rec	Rectangle we check against.
     * @return
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
     * We're really making too many rectangles here. Just use the friggin'
     * reference already and store it somewhere! Just move it around!
     * TODO: Learn to code.
     */
    protected int positionFromPad(Pad pad) {
    	Rectangle r = new Rectangle((int)pad.getPosX(), (int)pad.getPosY() - (int)(pad.getHeight()), 
    			(int)pad.getWidth(), (int)pad.getHeight());
    	
    	return r.outcode(getPosX(), getPosY());
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
     * Java awt uses different coordinates than OpenGL (which the logic uses),
     * so this section will seem very weird.
     * @param pad	The pad we are testing against.
     * @return	True if collides, false otherwise
     */
    public boolean collidesWith(Pad pad) {
    	
    	return collidesWithRectangle(
    			new Rectangle((int)pad.getPosX(), (int)pad.getPosY() - (int)pad.getHeight(), 
    						(int)pad.getWidth(), (int)pad.getHeight()));
    }
    
    
    /**
     * If the ball meats a border it turns back in a mirror angle.
     * TODO: Still travel the whole trip if you're going to collide.
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
    
    
    @Override
    public boolean collidesWith(Entity entity) {
    	return false;
    }
    
    
    public void collideWithPad(float baseYVel, Pad pad) {
    	
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
     * @param boardWidth Width of the tested board
     * @return	true if ball is at the left side, false otherwise
     */
    public boolean atLeftSide(float boardWidth) {
    	if( getPosX() < boardWidth/2) {
    		return true;
    	}
    	return false;
    }
    
    
    public void reset(float boardWidth, float boardHeight, float velocityX, float velocityY) {
    	setPosX(boardWidth/2); setPosY(boardHeight/2);
    	setVelX(velocityX); setVelY(velocityY);
    }
    
    
}