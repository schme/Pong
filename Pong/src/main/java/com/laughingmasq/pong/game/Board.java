
package com.laughingmasq.pong.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.laughingmasq.pong.EntityType;
import com.laughingmasq.pong.InputHandler;


/**
 * Board class represents the current playing board and the rules within it.
 * @author schme
 */
public class Board {
	
	private float ballXVel = 15;
	private float ballYVelBase = 4;
	
	private float boardWidth;
	private float boardHeight;

    private Ball ball;
    private Pad padLeft;
    private Pad padRight;
    
    private InputHandler inputHandler;

    private List<Entity> entities = new ArrayList<Entity>();
    
    private Random rng;
    
    
    /**
     * Creates one ball and left- and right pads in their corresponding 
     * positions.
     */
    public Board(float boardWidth, float boardHeight) {
    	
    	rng = new Random();
    	
    	this.boardWidth = boardWidth;
    	this.boardHeight = boardHeight;
    	
        this.ball = new Ball(boardWidth, boardHeight, 
        					 randomSign()*ballXVel, randomSign()*ballYVelBase);
        this.padLeft = new Pad(EntityType.LEFTPAD, boardWidth, boardHeight);
        this.padRight = new Pad(EntityType.RIGHTPAD, boardWidth, boardHeight);
        
        //add entitities
        entities.add(this.ball);
        entities.add(this.padLeft);
        entities.add(this.padRight);
        
        inputHandler = new InputHandler(this);
    }

    
    /**
     * Create a random sign.
     * @return	Either 1 or -1
     */
    private int randomSign() {
    	
    	
    	/* It's so pretty I just want to keep it here. Note recursion.
    	 * Not sure what I was thinking though.

    	int n = rng.nextInt(100) - 50;
    	if(n == 0) {
    		return randomSign();
    	}
    	
    	return n/Math.abs(n);
    	*/
    	
    	return (rng.nextBoolean() ? 1 : -1);
    }
    
    
    
    /**
     * Moves all the entities within their board limits.
     */
    public void moveEntities() {
    	
    	// Ball movement
    	if( ball.collidesWith(padLeft)) {
    		
    		ball.collideWithPad(ballYVelBase, padLeft);
    	}
    	else if( ball.collidesWith(padRight)) {
    		
    		ball.collideWithPad(ballYVelBase, padRight);
    	}
    	
    	ball.moveWithin2D(boardWidth, boardHeight);
    	padLeft.moveWithin2D(boardWidth, boardHeight);
    	padRight.moveWithin2D(boardWidth, boardHeight);
    	
    	/**
    	 * I really have to think this through. Keep it here as a reminder.
    	for( Entity e : entities) {
    		e.moveWithin2D(boardWidth, boardHeight);
    	}
    	*/
    }
    
    
    public float getBoardWidth() {
		return boardWidth;
	}
    
    public float getBoardHeight() {
		return boardHeight;
	}
    
    public Ball getBall() {
		return ball;
	}
    
    
    public Pad getPadLeft() {
		return padLeft;
	}
    
    
    public Pad getPadRight() {
		return padRight;
	}
    
    
    public List<Entity> getEntities() {
		return entities;
	}
    
   
    public void handleInput() {
    	inputHandler.handleInput();
    }
    
}