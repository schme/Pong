
package com.laughingmasq.pong.game;

import java.util.ArrayList;
import java.util.List;

import com.laughingmasq.pong.EntityType;
import com.laughingmasq.pong.InputHandler;


/**
 * Board class represents the current playing board and the rules within it.
 * @author schme
 */
public class Board {
	
	private float boardWidth;
	private float boardHeight;

    private Ball ball;
    private Pad padLeft;
    private Pad padRight;
    
    private InputHandler inputHandler;

    private List<Entity> entities = new ArrayList<Entity>();
    
    
    /**
     * Creates one ball and left- and right pads in their corresponding 
     * positions.
     */
    public Board(float boardWidth, float boardHeight) {
    	
    	this.boardWidth = boardWidth;
    	this.boardHeight = boardHeight;
    	
        this.ball = new Ball(boardWidth, boardHeight);
        this.padLeft = new Pad(EntityType.LEFTPAD, boardWidth, boardHeight);
        this.padRight = new Pad(EntityType.RIGHTPAD, boardWidth, boardHeight);
        
        //add entitities
        entities.add(this.ball);
        entities.add(this.padLeft);
        entities.add(this.padRight);
        
        inputHandler = new InputHandler(this);
    }

    
    /**
     * Moves all the entities within their board limits.
     */
    public void move() {
    	
    	for( Entity e : entities) {
    		e.moveWithin2D(boardWidth, boardHeight);
    	}
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