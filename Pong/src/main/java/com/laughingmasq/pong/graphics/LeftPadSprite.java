package com.laughingmasq.pong.graphics;

import org.lwjgl.opengl.GL11;

import com.laughingmasq.pong.game.Entity;

public class LeftPadSprite extends Sprite {

	public LeftPadSprite(Entity e) {
		super(e);
	}

	@Override
	public void draw() {
		// PLACEHOLDERS FOR TESTING
		GL11.glColor3f(1.0f,0.5f,0.8f);
		 
	    // draw quad
	    GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(100,100);
		GL11.glVertex2f(100+200,100);
		GL11.glVertex2f(100+200,100+200);
		GL11.glVertex2f(100,100+200);
	    GL11.glEnd();
	}
}
