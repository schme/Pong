package com.laughingmasq.pong.graphics;

import org.lwjgl.opengl.GL11;

import com.laughingmasq.pong.game.Entity;
import com.laughingmasq.pong.game.Ball;

public class BallSprite extends Sprite {
	
	private int radius;

	public BallSprite(Entity e) {
		super(e);
	}
	
	private void getRadius() {
		int radius = ((Ball)super.getEntity()).getRadius();
		
	}

	@Override
	public void draw() {
		
		// PLACEHOLDERS FOR TESTING
		GL11.glColor3f(0.6f,1.0f,0.6f);
		 
	    // draw quad
	    GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(100,600);
		GL11.glVertex2f(100+200,100+600);
		GL11.glVertex2f(100+200,600+200);
		GL11.glVertex2f(100,100+200);
	    GL11.glEnd();
		
	}
}