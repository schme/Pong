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
			
	/**
	 * Stores the entity this sprite corresponds to.
	 * @param entity		Given entity.
	 */
	public BallSprite(Entity entity) {
		super(entity);
	}

	
	/**
	 * Gets the radius of the ball from the ball entity.
	 * @return
	 */
	private float getRadius() {
		 return ((Ball) getEntity()).getRadius();
	}

	
	/**
	 * Draws the ball.
	 */
	@Override
	public void draw() {

		// Colour
		GL11.glColor3f(0.0f,0.6f,0.0f);

		// Filled circle
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);

		for (int i=0; i < 360; i++)
		{
			float degInRad = i*DEG2RAD;
			GL11.glVertex2f((float)Math.cos(degInRad)*getRadius() + getPositionX(),
							(float)Math.sin(degInRad)*getRadius() + getPositionY());
		}

		GL11.glEnd();
	}
}