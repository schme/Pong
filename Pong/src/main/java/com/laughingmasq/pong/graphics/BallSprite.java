package com.laughingmasq.pong.graphics;

import org.lwjgl.opengl.GL11;

public class BallSprite implements Sprite {

	@Override
	public void draw() {
		
		// PLACEHOLDERS FOR TESTING
		GL11.glColor3f(0.0f,0.3f,0.0f);
		 
	    // draw quad
	    GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(100,600);
		GL11.glVertex2f(100+200,100+600);
		GL11.glVertex2f(100+200,600+200);
		GL11.glVertex2f(100,100+200);
	    GL11.glEnd();
		
	}
}
