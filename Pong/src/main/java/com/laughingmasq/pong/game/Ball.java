package com.laughingmasq.pong.game;

import java.util.Random;

import com.laughingmasq.pong.graphics.SpriteType;

/**
 * @author schme
 */
public class Ball extends Entity {

    private int radius = 30;
    
    private Random rng;


    public Ball(double posX, double posY) {
    	super(SpriteType.BALL, posX, posY);
    	
    	rng = new Random();
    	super.setVelX(rng.nextDouble() * 5);
    	super.setVelY(rng.nextDouble() * 5);
    }
    
    public int getRadius() {
		return radius;
	}
}