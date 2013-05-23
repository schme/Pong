package com.laughingmasq.pong.game;

import java.util.Random;

import com.laughingmasq.pong.graphics.SpriteTypes;

/**
 * @author schme
 */
public class Ball extends Entity {

    private int radius = 30;
    
    private Random rng;


    public Ball(double posX, double posY) {
    	super(SpriteTypes.BALL, posX, posY);
    	
    	rng = new Random();
    	super.setVelX(rng.nextDouble() * 5);
    	super.setVelY(rng.nextDouble() * 5);
    }
    
}