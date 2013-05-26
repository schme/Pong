package com.laughingmasq.pong.graphics;

import org.lwjgl.opengl.GL11;

import com.laughingmasq.pong.game.Entity;
import com.laughingmasq.pong.game.Ball;

public class BallSprite extends Sprite {

	final float DEG2RAD = (float)3.14159/180;
			
	public BallSprite(Entity entity) {
		super(entity);
	}

	private float getRadius() {
		 return ((Ball) super.getEntity()).getRadius();
	}

	@Override
	public void draw() {

		//placeholder graphics
		GL11.glColor3f(0.6f,1.0f,0.6f);

		GL11.glBegin(GL11.GL_LINE_LOOP);

		for (int i=0; i < 360; i++)
		{
			float degInRad = i*DEG2RAD;
			GL11.glVertex2f((float)Math.cos(degInRad)*getRadius() + super.getPositionX(),
							(float)Math.sin(degInRad)*getRadius() + super.getPositionY());
		}

		GL11.glEnd();
	}
}