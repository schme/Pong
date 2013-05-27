
package com.laughingmasq.pong.game;

import java.util.ArrayList;
import java.util.List;

import com.laughingmasq.pong.graphics.SpriteType;


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
        this.padLeft = new Pad(SpriteType.LEFTPAD, 
        					padWidth + padPadding, 
        					boardHeight/2 - padHeight/2, 
        					padWidth, padHeight);
        this.padRight = new Pad(SpriteType.RIGHTPAD, 
        					boardWidth - padWidth - padPadding, 
        					boardHeight/2 - padHeight/2,
        					padWidth, padHeight);
        
        //add entitities
        entities.add(this.ball);
        entities.add(this.padLeft);
        entities.add(this.padRight);
        
    }

    /**
     * Moves all the entities within thei board limits.
     */
    public void move() {
    	for( Entity e : entities) {
    		e.moveWithin2D(boardWidth, boardHeight);
    	}
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
    
}