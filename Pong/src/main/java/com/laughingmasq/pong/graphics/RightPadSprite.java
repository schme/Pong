package com.laughingmasq.pong.graphics;

import org.lwjgl.opengl.GL11;

public class RightPadSprite implements Sprite {

	@Override
	public void draw() {
		// PLACEHOLDERS FOR TESTING
		GL11.glColor3f(0.0f,0.0f,0.5f);
		 
	    // draw quad
	    GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(600,600);
		GL11.glVertex2f(600,500);
		GL11.glVertex2f(500,550);
		GL11.glVertex2f(550,600);
	    GL11.glEnd();
	}

}
