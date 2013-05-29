
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
	
	private final float boardWidth = 1440;
	private final float boardHeight = 900;

    private Ball ball;
    private Pad padLeft;
    private Pad padRight;
    
    private InputHandler inputHandler;
    
	//How far the pad should be from the side
	//TODO: adjust
	private int padPadding = 50;
	private int padWidth = 15;
	private int padHeight = 140;
    

    private List<Entity> entities = new ArrayList<Entity>();
    
    
    /**
     * Creates one ball and left- and right pads in their corresponding 
     * positions.
     */
    public Board() {
    	
        this.ball = new Ball(boardWidth/2, boardHeight/2);
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