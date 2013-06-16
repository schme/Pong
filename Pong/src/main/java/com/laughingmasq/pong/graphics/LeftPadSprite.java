package com.laughingmasq.pong.graphics;

import org.lwjgl.opengl.GL11;

import com.laughingmasq.pong.game.Pad;

import com.laughingmasq.pong.game.Entity;


/**
 * Sprite for the left player pad.
 * @author schme
 */
public class LeftPadSprite extends Sprite {
	

	/**
	 * Stores the left pad entity.
	 * @param entity	Left pad entity
	 */
	public LeftPadSprite(Entity entity) {
		super(entity);
	}

	
	@Override
	public void draw() {
		
		// PLACEHOLDERS FOR TESTING
		GL11.glColor3f(1.0f,0.5f,0.8f);
		
		float posX = getPositionX();
		float posY = getPositionY();
		float width = getWidth();
		float height = getHeight();
		 
	    // draw quad
	    GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(posX, posY);
		GL11.glVertex2f(posX+width,posY);
		GL11.glVertex2f(posX+width,posY-height);
		GL11.glVertex2f(posX,posY-height);
	    GL11.glEnd();
	}
	
	
	/**
	 * Retrieves the pad width from the pad entity.
	 * @return		Current width of the pad.
	 */
	private float getWidth() {
		return ((Pad)getEntity()).getWidth();
	}
	
	
	/**
	 * Retrieves the pad height from the pad entity.
	 * @return		Current height of the pad.
	 */
	private float getHeight() {
		return ((Pad)getEntity()).getHeight();
	}
}