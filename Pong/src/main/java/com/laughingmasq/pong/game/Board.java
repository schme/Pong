
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
	
	private float ballXVel = 10;
	private float ballYVelBase = 4;
	private int leftScore = 0;
	private int rightScore = 0;
	
	private boolean paused = false;
	
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

    	return (rng.nextBoolean() ? 1 : -1);
    }
    
    
    private void scoreSide( boolean ballAtLeft) {
    	if( ballAtLeft) {
    		++rightScore;
    	} else {
    		++leftScore;
    	}
    	System.out.println("Left Score: " + leftScore);
    	System.out.println("Right Score: " + rightScore);
    }
    
    
    public int getLeftScore() {
		return leftScore;
	}
    
    public int getRightScore() {
		return rightScore;
	}
    
    
    /**
     * Moves all the entities within their board limits.
     */
    public boolean moveEntities() {
    	
    	boolean scored = false;
    	
    	// Ball movement
    	if( ball.collidesWith(padLeft)) {
    		
    		ball.collideWithPad(ballYVelBase, padLeft);
    	}
    	else if( ball.collidesWith(padRight)) {
    		
    		ball.collideWithPad(ballYVelBase, padRight);
    	}

    	/* true when ball hits the left or right border */
    	if(scored = ball.moveWithin2D(boardWidth, boardHeight)) {
    		scoreSide( ball.atLeftSide(boardWidth));
    	}
    	padLeft.moveWithin2D(boardWidth, boardHeight);
    	padRight.moveWithin2D(boardWidth, boardHeight);
    	
    	return scored;
    }
    
    
    public void resetBall() {
        ball.reset(boardWidth, boardHeight, 
        		randomSign()*ballXVel, randomSign()*ballYVelBase);
    }
    
    
    public void pause() {
    	paused = !paused;
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
    
    
    public boolean isPaused() {
		return paused;
	}
    
    
    public void handleInput() {
    	inputHandler.handleInput();
    }
    
}