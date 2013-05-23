
package com.laughingmasq.pong.game;

import java.util.ArrayList;
import java.util.List;

import com.laughingmasq.pong.graphics.SpriteTypes;


/**
 * @author schme
 */
public class Board {
	
	private final double boardWidth = 1440;
	private final double boardHeight = 900;

    private Ball ball;
    private Pad padLeft;
    private Pad padRight;
    

    private List<Entity> entities = new ArrayList<Entity>();
    
    
    public Board() {
        this.ball = new Ball(boardWidth, boardHeight);
        this.padLeft = new Pad(SpriteTypes.LEFTPAD, boardWidth, boardHeight);
        this.padRight = new Pad(SpriteTypes.RIGHTPAD, boardWidth, boardHeight);
        
        //add entitities
        entities.add(this.ball);
        entities.add(this.padLeft);
        entities.add(this.padRight);
        
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