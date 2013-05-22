package com.laughingmasq.pong.game;

import java.util.Random;

/**
 * @author schme
 */
public class Ball extends Entity {

    private int radius = 30;
    
    private Random rng;


    public Ball() {
    	super(1400/2, 900/2);
    	
    	rng = new Random();
    }
    
}
