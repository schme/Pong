
package com.laughingmasq.pong.game;

import java.util.ArrayList;
import java.util.List;


/**
 * @author schme
 */
public class Board {

    private Ball ball;
    private Pad padLeft;
    private Pad padRight;
    
    /** List of entities for drawing purposes */
    private List<Entity> entities = new ArrayList<Entity>();
    
    public Board() {
        this.ball = new Ball();
        this.padLeft = new Pad(0);
        this.padRight = new Pad(1);
        
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