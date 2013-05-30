package com.laughingmasq.pong.graphics;

import org.lwjgl.opengl.GL11;

import com.laughingmasq.pong.game.Entity;
import com.laughingmasq.pong.game.Ball;

/**
 * Sprite for the ball. Doesn't have much options yet, have to add for different
 * kinds of balls.
 * @author schme
 *
 */
public class BallSprite extends Sprite {

	/** for faster circle drawing */
	private final float DEG2RAD = (float)3.14159/180;
			
	/** Calls the Sprites constructor with given entity */
	public BallSprite(Entity entity) {
		super(entity);
	}

	
	private float getRadius() {
		 return ((Ball) getEntity()).getRadius();
	}

	
	/**
	 * Draws the ball.
	 */
	@Override
	public void draw() {

		//placeholder graphics
		GL11.glColor3f(0.6f,1.0f,0.6f);

		GL11.glBegin(GL11.GL_LINE_LOOP);

		for (int i=0; i < 360; i++)
		{
			float degInRad = i*DEG2RAD;
			GL11.glVertex2f((float)Math.cos(degInRad)*getRadius() + getPositionX(),
							(float)Math.sin(degInRad)*getRadius() + getPositionY());
		}

		GL11.glEnd();
	}
}