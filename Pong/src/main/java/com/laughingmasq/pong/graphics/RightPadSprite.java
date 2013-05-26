package com.laughingmasq.pong.graphics;

import org.lwjgl.opengl.GL11;

import com.laughingmasq.pong.game.Entity;
import com.laughingmasq.pong.game.Pad;

public class RightPadSprite extends Sprite {
	
	public RightPadSprite(Entity entity) {
		super(entity);
	}

	@Override
	public void draw() {
		// PLACEHOLDERS FOR TESTING
		GL11.glColor3f(0.5f,0.5f,1.0f);
		
		float posX = (float)getPositionX();
		float posY = (float)getPositionY();
		float width = (float)getWidth();
		float height = (float)getHeight();
		 
	    // draw quad
	    GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(posX, posY);
		GL11.glVertex2f(posX+width,posY);
		GL11.glVertex2f(posX+width,posY+height);
		GL11.glVertex2f(posX,posY+height);
	    GL11.glEnd();
	}
	
	private float getWidth() {
		return ((Pad)super.getEntity()).getWidth();
	}
	
	private float getHeight() {
		return ((Pad)super.getEntity()).getHeight();
	}
}