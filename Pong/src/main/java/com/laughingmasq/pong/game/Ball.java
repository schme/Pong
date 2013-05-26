package com.laughingmasq.pong.game;

import java.util.Random;

import com.laughingmasq.pong.graphics.SpriteType;

/**
 * @author schme
 */
public class Ball extends Entity {

    private int radius = 15;
    
    private Random rng;


    public Ball(float posX, float posY) {
    	super(SpriteType.BALL, posX, posY);
    	
    	rng = new Random();
    	super.setVelX(rng.nextFloat() * 5);
    	super.setVelY(rng.nextFloat() * 5);
    }
    
    public int getRadius() {
		return radius;
	}
}